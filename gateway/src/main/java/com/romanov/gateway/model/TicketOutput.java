package com.romanov.gateway.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Value
@Builder
@Jacksonized
public class TicketOutput {
    UUID ticketUid;
    String flightNumber;
    Integer price;
    String status;
}
