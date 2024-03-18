package com.eastrabbit.identitynumber;

import com.eastrabbit.identitynumber.exception.IdentityCardNumberFormatException;
import com.eastrabbit.identitynumber.validator.IdentityCard;
import com.eastrabbit.identitynumber.validator.IdentityCardNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdentityCardNumberValidatorTest {

    @Test
    public void givenCorrectIdentityNumber_whenValidating_thenReturnsTrue() {
        try {
            IdentityCardNumberValidator.valid(IdentityCard.create("A123456789"));
        } catch (IdentityCardNumberFormatException e) {
            Assertions.fail();
        }
    }

    @Test
    public void givenLowerCaseIdentityNumber_whenValidating_thenReturnsFalse() {
        IdentityCardNumberFormatException exception = assertThrows(IdentityCardNumberFormatException.class, () -> {
            IdentityCardNumberValidator.valid(IdentityCard.create("a123456789"));
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void givenWrongFirstLetterIdentityNumber_whenValidating_thenReturnsFalse() {

        IdentityCardNumberFormatException exception = assertThrows(IdentityCardNumberFormatException.class, () -> {
            IdentityCardNumberValidator.valid(IdentityCard.create("@123456789"));
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void givenWrongIdentityNumber_whenValidating_thenReturnsFalse() {
        IdentityCardNumberFormatException exception = assertThrows(IdentityCardNumberFormatException.class, () -> {
            IdentityCardNumberValidator.valid(IdentityCard.create("A000000000"));
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}