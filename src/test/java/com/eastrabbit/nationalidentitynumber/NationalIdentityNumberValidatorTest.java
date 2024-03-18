package com.eastrabbit.nationalidentitynumber;

import com.eastrabbit.nationalidentitynumber.exception.InvalidIdentityCardNumberException;
import com.eastrabbit.nationalidentitynumber.validator.NationalIdentityNumberValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NationalIdentityNumberValidatorTest {

    @Test
    public void test1() throws InvalidIdentityCardNumberException {
        NationalIdentityNumberValidator.valid("A123456789");
    }

    @Test
    public void test2() {
        InvalidIdentityCardNumberException exception = assertThrows(InvalidIdentityCardNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("a123456789");
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test3() {

        InvalidIdentityCardNumberException exception = assertThrows(InvalidIdentityCardNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("@123456789");
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test4() {
        InvalidIdentityCardNumberException exception = assertThrows(InvalidIdentityCardNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("A000000000");
        });
        String expectedMessage = "Wrong format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test5() {
        InvalidIdentityCardNumberException exception = assertThrows(InvalidIdentityCardNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("A123456788");
        });
        String expectedMessage = "Invalid identity card number.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}