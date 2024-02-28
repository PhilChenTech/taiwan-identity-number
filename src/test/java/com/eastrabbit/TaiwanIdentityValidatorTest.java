package com.eastrabbit;

import com.eastrabbit.identity_number.validator.TaiwanIdentityValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaiwanIdentityValidatorTest {

    @Test
    public void givenCorrectIdentityNumber_whenValidating_thenReturnsTrue() {
        assert TaiwanIdentityValidator.valid("A123456789");
    }

    @Test
    public void givenLowerCaseIdentityNumber_whenValidating_thenReturnsFalse() {
        Assertions.assertFalse(TaiwanIdentityValidator.valid("a123456789"));;
    }
    @Test
    public void givenWrongFirstLetterIdentityNumber_whenValidating_thenReturnsFalse() {
        Assertions.assertFalse(TaiwanIdentityValidator.valid("@123456789"));;
    }

    @Test
    public void givenWrongIdentityNumber_whenValidating_thenReturnsFalse() {
        Assertions.assertFalse(TaiwanIdentityValidator.valid("A000000000"));;
    }


}