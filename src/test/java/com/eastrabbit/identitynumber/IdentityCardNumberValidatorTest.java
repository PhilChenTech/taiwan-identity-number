package com.eastrabbit.identitynumber;

import com.eastrabbit.identitynumber.exception.IdentityCardNumberException;
import com.eastrabbit.identitynumber.exception.IdentityCardNumberFormatException;
import com.eastrabbit.identitynumber.validator.IdentityCardNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdentityCardNumberValidatorTest {

    @Test
    public void givenCorrectIdentityNumber_whenValidating_thenReturnsTrue() throws IdentityCardNumberException, IdentityCardNumberFormatException {
        IdentityCardNumberValidator.valid("A123456789");
    }

    @Test
    public void givenLowerCaseIdentityNumber_whenValidating_thenReturnsFalse() {
        IdentityCardNumberFormatException exception = assertThrows(IdentityCardNumberFormatException.class, () -> {
            IdentityCardNumberValidator.valid("a123456789");
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void givenWrongFirstLetterIdentityNumber_whenValidating_thenReturnsFalse() {

        IdentityCardNumberFormatException exception = assertThrows(IdentityCardNumberFormatException.class, () -> {
            IdentityCardNumberValidator.valid("@123456789");
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void givenWrongIdentityNumber_whenValidating_thenReturnsFalse() {
        IdentityCardNumberFormatException exception = assertThrows(IdentityCardNumberFormatException.class, () -> {
            IdentityCardNumberValidator.valid("A000000000");
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}