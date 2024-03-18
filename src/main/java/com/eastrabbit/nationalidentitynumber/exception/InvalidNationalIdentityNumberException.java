package com.eastrabbit.nationalidentitynumber.exception;

import com.eastrabbit.nationalidentitynumber.validator.ErrorMessage;

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
