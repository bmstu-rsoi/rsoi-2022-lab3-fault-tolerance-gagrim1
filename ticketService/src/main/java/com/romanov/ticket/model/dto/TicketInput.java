package com.romanov.ticket.model.dto;

import lombok.Value;

@Value
public class TicketInput {
    String flightNumber;
    Integer price;
}
