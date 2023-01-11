package com.romanov.privilege.service.impl;

import com.romanov.privilege.exception.NotFoundException;
import com.romanov.privilege.model.PrivilegeEntity;
import com.romanov.privilege.model.dto.*;
import com.romanov.privilege.model.mapper.PrivilegeMapper;
import com.romanov.privilege.repository.PrivilegeRepository;
import com.romanov.privilege.service.PrivilegeHistoryService;
import com.romanov.privilege.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrivilegeServiceImpl implements PrivilegeService {
    private final PrivilegeRepository repository;
    private final PrivilegeMapper mapper;
    private final PrivilegeHistoryService historyService;

    @Override
    public PrivilegeOutput get(String username) {
        return mapper.convert(getEntity(username));
    }

    @Override
    public PrivilegeWithHistoryOutput getWithHistory(String username) {
        PrivilegeEntity entity = getEntity(username);
        PrivilegeOutput privilege = mapper.convert(entity);
        List<PrivilegeHistoryOutput> history = historyService.getByPrivilegeId(entity.getId());
        return new PrivilegeWithHistoryOutput(privilege.getStatus(), privilege.getBalance(), history);
    }

    @Override
    @Transactional
    public BonusOutput calculatePrice(CalculationPriceInput input) {
        Integer price = input.getPrice();
        PrivilegeEntity entity = repository.findByUsername(input.getUsername())
                .orElseThrow(() -> new NotFoundException(
                        "Privilege of user: " + input.getUsername() + " not found!")
                );
        BonusOutput output = new BonusOutput();
        PrivilegeOutput privilegeOutput = PrivilegeOutput.builder()
                .status(entity.getStatus())
                .balance(entity.getBalance())
                .build();

        if (input.getPaidFromBonuses()) {
            DiscountOutput discountOutput = discountPrice(entity, input.getTicketUid(), price);
            privilegeOutput.setBalance(discountOutput.getNewBalance());
            output.setPaidByMoney(discountOutput.getPriceAfterDiscount());
            output.setPaidByBonuses(discountOutput.getPriceDifference());
            output.setPrivilege(privilegeOutput);
        } else {
            Integer cashback = deposit(entity, input.getTicketUid(), price);
            privilegeOutput.setBalance(privilegeOutput.getBalance() + cashback);
            output.setPaidByMoney(price);
            output.setPaidByBonuses(0);
            output.setPrivilege(privilegeOutput);
        }
        return output;
    }

    @Override
    @Transactional
    public Integer deposit(PrivilegeEntity entity, UUID ticketUid, Integer price) {
        Double cashback = price * 0.1;
        repository.deposit(entity.getId(), cashback.intValue());
        historyService.saveHistory(new UpdateHistoryInput(entity,
                ticketUid,
                cashback.intValue(),
                "FILL_IN_BALANCE"));
        log.info(cashback + " was deposited to the privilege with id: " + entity.getId());
        return cashback.intValue();
    }

    @Override
    public DiscountOutput discountPrice(PrivilegeEntity entity, UUID ticketUid, Integer price) {
        int balance = entity.getBalance();
        int priceAfterDiscount;
        int difference = price - balance;

        if (difference > 0) {
            priceAfterDiscount = difference;
            balance = 0;
        } else {
            priceAfterDiscount = 0;
            balance = -difference;
        }
        difference = price - priceAfterDiscount;
        updateBalance(entity, balance);

        historyService.saveHistory(new UpdateHistoryInput(entity,
                ticketUid,
                difference,
                "DEBIT_THE_ACCOUNT"));
        log.info("Price: " + price + " was withdrawn from " + entity.getUsername() + "'s bonus account");
        return DiscountOutput.builder()
                .privilegeId(entity.getId())
                .price(price)
                .priceAfterDiscount(priceAfterDiscount)
                .priceDifference(difference)
                .newBalance(balance)
                .build();
    }

    public void updateBalance(PrivilegeEntity entity, Integer newBalance) {
        entity.setBalance(newBalance);
        repository.save(entity);
    }

    @Override
    public void returnBonus(String username, UUID ticketUid) {
        PrivilegeHistoryOutput history = historyService.getByTicketUid(ticketUid);
        PrivilegeEntity privilege = getEntity(username);
        String operationType = history.getOperationType();
        Integer balance = privilege.getBalance();
        Integer balanceDiff = history.getBalanceDiff();
        if (operationType.equals("FILL_IN_BALANCE")) {
            privilege.setBalance(balance - balanceDiff);
        } else if (operationType.equals("DEBIT_THE_ACCOUNT")) {
            privilege.setBalance(balance + balanceDiff);
        }
        repository.save(privilege);
    }

    private PrivilegeEntity getEntity(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User do not have a privilege."));
    }

}
