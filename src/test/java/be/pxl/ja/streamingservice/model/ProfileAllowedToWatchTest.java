package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileAllowedToWatchTest {

    private Movie movieLittleKids;
    private Movie movieOlderKids;
    private Movie movieTeens;
    private Movie movieMature;

    private Profile littleKid;
    private Profile olderKid;
    private Profile teen;
    private Profile mature;

    @BeforeEach
    public void init() {
        movieLittleKids = new Movie("Little Kids", Rating.LITTLE_KIDS);
        movieOlderKids = new Movie("Older Kids", Rating.OLDER_KIDS);
        movieTeens = new Movie("Teens", Rating.TEENS);
        movieMature = new Movie("Mature", Rating.MATURE);

        littleKid = new Profile("Jan");
        olderKid = new Profile("Piet");
        teen = new Profile("Joris");
        mature = new Profile("Corneel");
    }

    @Test
    public void returnsTrueWhenOldEnoughToWatch() {
        littleKid.setDateOfBirth(LocalDate.of(LocalDate.now().getYear() - 1, 1, 1));
        olderKid.setDateOfBirth(LocalDate.of(LocalDate.now().getYear() - 8, 1, 1));
        teen.setDateOfBirth(LocalDate.of(LocalDate.now().getYear() - 13, 1, 1));
        mature.setDateOfBirth(LocalDate.of(LocalDate.now().getYear() - 17, 1, 1));

        assertTrue(littleKid.allowedToWatch(movieLittleKids));
        assertTrue(olderKid.allowedToWatch(movieOlderKids));
        assertTrue(teen.allowedToWatch(movieTeens));
        assertTrue(mature.allowedToWatch(movieMature));
    }

    @Test
    public void returnsFalseWhenNotOldEnoughToWatch() {
        littleKid.setDateOfBirth(LocalDate.of(LocalDate.now().getYear(), 1, 1));
        olderKid.setDateOfBirth(LocalDate.of(LocalDate.now().getYear() - 8, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth() + 1));
        //teen.setDateOfBirth(LocalDate.of(LocalDate.now().getYear() - 12, LocalDate.now().getMonth() - 1, 1)); RETURNS OBJECT, NOT INT LIKE YEAR AND DAY
        teen.setDateOfBirth(LocalDate.of(LocalDate.now().getYear() - 11, 1, 1));
        mature.setDateOfBirth(LocalDate.of(LocalDate.now().getYear() - 15, 1, 1));

        assertFalse(littleKid.allowedToWatch(movieLittleKids));
        assertFalse(olderKid.allowedToWatch(movieOlderKids));
        assertFalse(teen.allowedToWatch(movieTeens));
        assertFalse(mature.allowedToWatch(movieMature));
    }

    @Test
    public void returnsFalseWhenNoDateOfBirthIsSet() {
        assertFalse(littleKid.allowedToWatch(movieLittleKids));
        assertFalse(olderKid.allowedToWatch(movieOlderKids));
        assertFalse(teen.allowedToWatch(movieTeens));
        assertFalse(mature.allowedToWatch(movieMature));
    }
}
