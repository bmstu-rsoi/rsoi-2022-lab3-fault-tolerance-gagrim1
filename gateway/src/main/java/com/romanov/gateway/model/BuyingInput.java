package com.romanov.gateway.model;

import lombok.Value;

@Value
public class BuyingInput {
    String flightNumber;
    Integer price;
    Boolean paidFromBalance;
}
