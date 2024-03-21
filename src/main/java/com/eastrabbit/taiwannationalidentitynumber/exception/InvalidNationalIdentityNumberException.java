package com.eastrabbit.taiwannationalidentitynumber.exception;

import com.eastrabbit.taiwannationalidentitynumber.validator.ErrorMessage;

public class InvalidNationalIdentityNumberException extends Throwable {

    private final ErrorMessage errorMessage;

    public InvalidNationalIdentityNumberException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage.name();
    }

}
