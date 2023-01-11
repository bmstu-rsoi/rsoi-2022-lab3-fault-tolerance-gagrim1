package com.romanov.gateway.exception;

import org.springframework.http.HttpStatus;

public class BonusServiceNotAvailableException extends ServiceNotAvailableException {
    private static final String MESSAGE = "GATEWAY: Bonus service is not available, code=%s.";

    public BonusServiceNotAvailableException(HttpStatus httpStatus) {
        super(String.format(MESSAGE, httpStatus.toString()));
    }
}
