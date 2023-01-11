package com.romanov.gateway.model;

import lombok.Value;

import java.util.List;

@Value
public class UserInfoOutput {
    List<FullTicketOutput> tickets;
    PrivilegeOutput privilege;
}
