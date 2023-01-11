package com.romanov.gateway.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class PrivilegeHistoryOutput {
    Integer id;
    Integer privilegeId;
    UUID ticketUid;
    String dateTime;
    Integer balanceDiff;
    String operationType;
}
