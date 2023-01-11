package com.romanov.privilege.service;

import com.romanov.privilege.model.dto.PrivilegeHistoryOutput;
import com.romanov.privilege.model.dto.UpdateHistoryInput;

import java.util.List;
import java.util.UUID;

public interface PrivilegeHistoryService {
    PrivilegeHistoryOutput getByTicketUid(UUID ticketUid);
    List<PrivilegeHistoryOutput> getByPrivilegeId(Integer privilegeId);
    void saveHistory(UpdateHistoryInput input);
}
