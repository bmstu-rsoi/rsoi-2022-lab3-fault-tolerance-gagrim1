package com.romanov.privilege.service;

import com.romanov.privilege.model.PrivilegeEntity;
import com.romanov.privilege.model.dto.*;

import java.util.UUID;

public interface PrivilegeService {
    PrivilegeOutput get(String username);
    PrivilegeWithHistoryOutput getWithHistory(String username);
    BonusOutput calculatePrice(CalculationPriceInput input);
    Integer deposit(PrivilegeEntity entity, UUID ticketUid, Integer price);
    DiscountOutput discountPrice(PrivilegeEntity entity, UUID ticketUid, Integer price);
    void returnBonus(String username, UUID ticketUid);
}
