package com.eastrabbit.identitynumber.validator;

import com.eastrabbit.identitynumber.exception.IdentityCardNumberFormatException;

public class IdentityCard {
    final String identityCardNumber;

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    private IdentityCard(final String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public static IdentityCard create(final String identityCardNumber) throws IdentityCardNumberFormatException {
        boolean result = IdentityCardNumberRegexCheckUtil.validFormat(identityCardNumber);
        if (!result) {
            throw new IdentityCardNumberFormatException();
        }
        return new IdentityCard(identityCardNumber);
    }
}
