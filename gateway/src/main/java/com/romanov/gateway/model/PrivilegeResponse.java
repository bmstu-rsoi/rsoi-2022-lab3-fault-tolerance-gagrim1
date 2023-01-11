package com.romanov.gateway.model;

import lombok.Value;

import java.util.List;

@Value
public class PrivilegeResponse {
    PrivilegeOutput output;
    List<PrivilegeHistoryOutput> history;
}
