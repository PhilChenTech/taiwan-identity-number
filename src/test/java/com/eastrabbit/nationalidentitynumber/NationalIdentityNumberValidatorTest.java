package com.eastrabbit.nationalidentitynumber;

import com.eastrabbit.nationalidentitynumber.exception.InvalidNationalIdentityNumberException;
import com.eastrabbit.nationalidentitynumber.validator.NationalIdentityNumberValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NationalIdentityNumberValidatorTest {

    @Test
    public void test1() throws InvalidNationalIdentityNumberException {
        NationalIdentityNumberValidator.valid("A123456789");
    }

    @Test
    public void test2() {
        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("a123456789");
        });
        String expectedMessage = "WRONG_FORMAT";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test3() {

        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("@123456789");
        });
        String expectedMessage = "WRONG_FORMAT";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test4() {
        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("A000000000");
        });
        String expectedMessage = "WRONG_FORMAT";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test5() {
        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("A123456788");
        });
        String expectedMessage = "INVALID_NATIONAL_IDENTITY_NUMBER";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}