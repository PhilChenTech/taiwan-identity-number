package com.eastrabbit.identitynumber;

import com.eastrabbit.identitynumber.exception.InvalidIdentityCardNumberException;
import com.eastrabbit.identitynumber.validator.IdentityCardNumberValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdentityCardNumberValidatorTest {

    @Test
    public void test1() throws InvalidIdentityCardNumberException {
        IdentityCardNumberValidator.valid("A123456789");
    }

    @Test
    public void test2() {
        InvalidIdentityCardNumberException exception = assertThrows(InvalidIdentityCardNumberException.class, () -> {
            IdentityCardNumberValidator.valid("a123456789");
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test3() {

        InvalidIdentityCardNumberException exception = assertThrows(InvalidIdentityCardNumberException.class, () -> {
            IdentityCardNumberValidator.valid("@123456789");
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test4() {
        InvalidIdentityCardNumberException exception = assertThrows(InvalidIdentityCardNumberException.class, () -> {
            IdentityCardNumberValidator.valid("A000000000");
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test5() {
        InvalidIdentityCardNumberException exception = assertThrows(InvalidIdentityCardNumberException.class, () -> {
            IdentityCardNumberValidator.valid("A123456788");
        });
        String expectedMessage = "Invalid identity card number.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}