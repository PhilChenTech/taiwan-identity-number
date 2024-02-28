package com.eastrabbit.identity_number;

import com.eastrabbit.identity_number.validator.TaiwanIdentityValidator;

public class TaiwanIdentityNumber {
    private final String identityNumber;

    public TaiwanIdentityNumber(String identityNumber) throws TaiwanIdentityNumberException {
        boolean result = TaiwanIdentityValidator.valid(identityNumber);
        if (!result) throw new TaiwanIdentityNumberException("Wrong taiwan identity number");
        this.identityNumber = identityNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    @Override
    public String toString() {
        return "TaiwanIdentityNumber{" +
                "identityNumber='" + identityNumber + '\'' +
                '}';
    }
}
