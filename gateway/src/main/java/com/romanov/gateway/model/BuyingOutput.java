package com.romanov.gateway.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BuyingOutput {
    private UUID ticketUid;
    private String flightNumber;
    private String fromAirport;
    private String toAirport;
    private String date;
    private Integer price;
    private Integer paidByMoney;
    private Integer paidByBonuses;
    private String status;
    private PrivilegeOutput privilege;
}