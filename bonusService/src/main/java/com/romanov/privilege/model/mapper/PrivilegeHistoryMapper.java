package com.romanov.privilege.model.mapper;

import com.romanov.privilege.model.PrivilegeHistoryEntity;
import com.romanov.privilege.model.dto.PrivilegeHistoryOutput;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class PrivilegeHistoryMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    public PrivilegeHistoryOutput convert(PrivilegeHistoryEntity entity) {
        return  PrivilegeHistoryOutput.builder()
                .id(entity.getId())
                .privilegeId(entity.getPrivilege().getId())
                .ticketUid(entity.getTicketUid())
                .date(entity.getDateTime().format(FORMATTER))
                .balanceDiff(entity.getBalanceDiff())
                .operationType(entity.getOperationType())
                .build();
    }
}
