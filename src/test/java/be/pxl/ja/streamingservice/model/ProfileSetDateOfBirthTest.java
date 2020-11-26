package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileSetDateOfBirthTest {

    private Profile profile;

    @BeforeEach
    public void init() {
        profile = new Profile("Anne-Marie");
    }

    @Test
    public void throwsInvalidDateExceptionWhenDateOfBirthIsAfterDateOfToday() {
        LocalDate future = LocalDate.now().plusDays(1);
        assertThrows(InvalidDateException.class, () -> profile.setDateOfBirth(future));
    }

    @Test
    public void throwsInvalidDateExceptionWhenBirthDateIsToday() {
        LocalDate today = LocalDate.now();
        assertThrows(InvalidDateException.class, () -> profile.setDateOfBirth(today));
    }

    @Test
    public void birthdateBeforeTodayIsAllowed() {
        LocalDate past = LocalDate.now().minusDays(1);
        profile.setDateOfBirth(past);

        assertNotNull(profile.getDateOfBirth());
        assertEquals(past, profile.getDateOfBirth());
    }
}
