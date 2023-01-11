package com.romanov.gateway.exception;

import org.springframework.http.HttpStatus;

public class TicketServiceNotAvailableException extends ServiceNotAvailableException {
    private static final String MESSAGE = "GATEWAY: Ticket service is not available, code=%s.";

    public TicketServiceNotAvailableException(HttpStatus httpStatus) {
        super(String.format(MESSAGE, httpStatus.toString()));
    }
}
