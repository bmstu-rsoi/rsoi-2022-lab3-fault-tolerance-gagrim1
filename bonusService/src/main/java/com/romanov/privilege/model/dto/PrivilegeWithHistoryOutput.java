package com.romanov.privilege.model.dto;

import lombok.Value;

import java.util.List;

@Value
public class PrivilegeWithHistoryOutput {
    String status;
    Integer balance;
    List<PrivilegeHistoryOutput> history;
}
