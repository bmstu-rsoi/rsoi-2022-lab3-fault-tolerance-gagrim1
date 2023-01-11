package com.romanov.ticket.model.dto;

import lombok.Value;

import java.util.UUID;

@Value
public class TicketOutput {
    UUID ticketUid;
    String flightNumber;
    Integer price;
    String status; // PAID или CANCELED
}
