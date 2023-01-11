package com.romanov.privilege.model.dto;

import com.romanov.privilege.model.PrivilegeEntity;
import lombok.Value;

import java.util.UUID;

@Value
public class UpdateHistoryInput {
    PrivilegeEntity privilege;
    UUID ticketUid;
    Integer difference;
    String operation;
}
