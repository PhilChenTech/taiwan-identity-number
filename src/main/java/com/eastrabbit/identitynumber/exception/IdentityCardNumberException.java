package com.eastrabbit.identitynumber.exception;

public class IdentityCardNumberException extends Throwable {

    private final String message;

    public IdentityCardNumberException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
