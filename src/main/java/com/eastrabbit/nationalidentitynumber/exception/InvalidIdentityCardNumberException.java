package com.eastrabbit.nationalidentitynumber.exception;

public class InvalidIdentityCardNumberException extends Throwable {

    private final String message;

    public InvalidIdentityCardNumberException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
