package com.eastrabbit.identitynumber.exception;

public class IdentityCardNumberException extends Throwable{
    private final String MESSAGE = "Invalid identity card number.";
    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
