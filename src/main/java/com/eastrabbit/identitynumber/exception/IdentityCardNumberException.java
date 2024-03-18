package com.eastrabbit.identitynumber.exception;

public class IdentityCardNumberException extends Throwable {
    @Override
    public String getMessage() {
        return "Invalid identity card number.";
    }
}
