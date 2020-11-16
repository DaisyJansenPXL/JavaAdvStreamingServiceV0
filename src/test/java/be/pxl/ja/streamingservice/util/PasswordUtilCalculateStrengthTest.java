package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordUtilCalculateStrengthTest {

    @Test
    public void PasswordStrengthWithLessThanSixCharactersReturnsZero() {
        assertEquals(0, PasswordUtil.calculateStrength("pxl"));
    }

    @Test
    public void PasswordStrengthWithMoreThanSixButLessThanTenCharactersWithOnlyLowercaseCharactersReturnsThree() {
        assertEquals(3, PasswordUtil.calculateStrength("pxlpxlpxl"));
    }

    @Test
    public void PasswordStrengthWithMoreThanSixButLessThanTenCharactersWithOnlyUppercaseCharactersReturnsThree() {
        assertEquals(3, PasswordUtil.calculateStrength("PXLPXL"));
    }

    @Test
    public void PasswordStrengthWithMoreThanSixButLessThanTenCharactersWithOnlyNumericalCharactersReturnsThree() {
        assertEquals(3, PasswordUtil.calculateStrength("1234567"));
    }

    @Test
    public void PasswordStrengthWithMoreThanSixButLessThanTenCharactersWithOnlySpecialCharactersReturnsThree() {
        assertEquals(3, PasswordUtil.calculateStrength("~!@#$^&*("));
    }

    @Test
    public void PasswordStrengthWithMoreThanSixButLessThanTenCharactersWithLowercaseAndUppercaseCharactersReturnsFive() {
        assertEquals(5, PasswordUtil.calculateStrength("PxlPxl"));
    }

    @Test
    public void PasswordStrengthWithMoreThanTenCharactersWithLowercaseAndUppercaseCharactersReturnsSix() {
        assertEquals(6, PasswordUtil.calculateStrength("PxlPxlPxlPxl"));
    }

    @Test
    public void PasswordStrengthWithMoreThanTenCharactersWithLowercaseAndUppercaseAndNumericalAndSpecialCharactersReturnsTen() {
        assertEquals(10, PasswordUtil.calculateStrength("Pxl123~pxlpxl"));
    }
}
