package com.eastrabbit.identitynumber.exception;


public class IdentityCardNumberFormatException extends Throwable {

    @Override
    public String getMessage() {
        return "Wrong format";
    }


}
