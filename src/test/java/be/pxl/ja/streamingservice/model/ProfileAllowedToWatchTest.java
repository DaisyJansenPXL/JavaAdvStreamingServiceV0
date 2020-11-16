package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ProfileAllowedToWatchTest {

    private Movie movie;
    private Profile profile;

    @BeforeEach
    public void init() {
        movie = new Movie("Titanic", Rating.TEENS);
        profile = new Profile("Jan");
    }

    @Test
    public void returnsTrueWhenOldEnoughToWatch() {
        profile.setDateOfBirth(LocalDate.of(2000, 5, 1));
    }

}
