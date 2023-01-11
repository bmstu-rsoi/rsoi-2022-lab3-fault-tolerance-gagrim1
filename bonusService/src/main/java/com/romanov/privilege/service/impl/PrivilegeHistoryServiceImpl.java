package com.romanov.privilege.service.impl;

import com.romanov.privilege.exception.NotFoundException;

import com.romanov.privilege.model.PrivilegeEntity;
import com.romanov.privilege.model.PrivilegeHistoryEntity;
import com.romanov.privilege.model.dto.PrivilegeHistoryOutput;
import com.romanov.privilege.model.dto.UpdateHistoryInput;
import com.romanov.privilege.model.mapper.PrivilegeHistoryMapper;
import com.romanov.privilege.repository.PrivilegeHistoryRepository;
import com.romanov.privilege.service.PrivilegeHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrivilegeHistoryServiceImpl implements PrivilegeHistoryService {
    private final PrivilegeHistoryRepository repository;
    private final PrivilegeHistoryMapper mapper;

    @Override
    public PrivilegeHistoryOutput getByTicketUid(UUID ticketUid) {
        PrivilegeHistoryEntity entity = repository.findByTicketUid(ticketUid)
                .orElseThrow(() -> new NotFoundException(""));
        return mapper.convert(entity);
    }

    @Override
    public List<PrivilegeHistoryOutput> getByPrivilegeId(Integer privilegeId) {
        return repository.findAllByPrivilegeId(privilegeId)
                .stream()
                .map(mapper::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void saveHistory(UpdateHistoryInput input) {
        repository.save(new PrivilegeHistoryEntity()
                .setPrivilege(input.getPrivilege())
                .setTicketUid(input.getTicketUid())
                .setBalanceDiff(input.getDifference())
                .setDateTime(LocalDateTime.now())
                .setOperationType(input.getOperation()));
    }
}

