package com.romanov.gateway.model;

import lombok.Value;

import java.util.UUID;

@Value
public class CalculationPriceInput {
    String username;
    UUID ticketUid;
    Integer price;
    Boolean paidFromBonuses;
}
