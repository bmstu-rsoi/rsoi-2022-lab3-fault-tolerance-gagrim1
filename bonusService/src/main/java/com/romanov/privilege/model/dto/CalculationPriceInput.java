package com.romanov.privilege.model.dto;

import lombok.Value;

import java.util.UUID;

@Value
public class CalculationPriceInput {
    String username;
    UUID ticketUid;
    Integer price;
    Boolean paidFromBonuses;
}
