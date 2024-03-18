package com.eastrabbit.identitynumber.exception;


public class IdentityCardNumberFormatException extends Throwable {
    private final String MESSAGE = "Wrong format";

    @Override
    public String getMessage() {
        return MESSAGE;
    }


}
