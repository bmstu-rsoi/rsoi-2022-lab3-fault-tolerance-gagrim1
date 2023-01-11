package com.romanov.gateway.model;

import lombok.Value;

import java.util.UUID;

@Value
public class FullTicketOutput {
    UUID ticketUid;
    String flightNumber;
    String fromAirport;
    String toAirport;
    String date;
    Integer price;
    String status;

}
