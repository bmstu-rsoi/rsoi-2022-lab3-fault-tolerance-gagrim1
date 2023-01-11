package com.romanov.gateway.exception;

import org.springframework.http.HttpStatus;

public class FlightServiceNotAvailableException extends ServiceNotAvailableException {
    private static final String MESSAGE = "GATEWAY: Flight service is not available, code=%s.";

    public FlightServiceNotAvailableException(HttpStatus httpStatus) {
        super(String.format(MESSAGE, httpStatus.toString()));
    }
}
