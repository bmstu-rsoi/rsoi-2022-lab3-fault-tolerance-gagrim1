package com.romanov.gateway.exception;

public class GatewayErrorException extends RuntimeException {
    public static String MESSAGE = "GATEWAY: error was caught, err=%s.";

    public GatewayErrorException(String error) {
        super(String.format(MESSAGE, error));
    }
}
