package com.eastrabbit.taiwannationalidentitynumber;

import com.eastrabbit.taiwannationalidentitynumber.exception.InvalidNationalIdentityNumberException;
import com.eastrabbit.taiwannationalidentitynumber.validator.ErrorMessage;
import com.eastrabbit.taiwannationalidentitynumber.validator.NationalIdentityNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NationalIdentityNumberValidatorTest {

    @Test
    @DisplayName("ssss")
    public void test1() throws InvalidNationalIdentityNumberException {
        NationalIdentityNumberValidator.valid("A123456789");
    }

    @Test
    public void test2() {
        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("a123456789");
        });
        String expectedMessage = ErrorMessage.WRONG_FORMAT.name();
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test3() {

        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("@123456789");
        });
        String expectedMessage = ErrorMessage.WRONG_FORMAT.name();
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test4() {
        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("A000000000");
        });
        String expectedMessage = ErrorMessage.WRONG_FORMAT.name();
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test5() {
        InvalidNationalIdentityNumberException exception = assertThrows(InvalidNationalIdentityNumberException.class, () -> {
            NationalIdentityNumberValidator.valid("A123456788");
        });
        String expectedMessage = ErrorMessage.INVALID_NATIONAL_IDENTITY_NUMBER.name();
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }


}