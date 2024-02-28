package com.eastrabbit.identity_number;

public class TaiwanIdentityNumberException extends Exception {
    final String message;

    public TaiwanIdentityNumberException(String message) {
        super(message);
        this.message = message;
    }


}
