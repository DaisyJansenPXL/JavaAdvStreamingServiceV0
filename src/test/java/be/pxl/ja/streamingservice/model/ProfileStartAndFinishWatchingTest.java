package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileStartAndFinishWatchingTest {

    private Content movie;
    private Content documentary;
    private Content tvShow;

    private Profile profile;

    @BeforeEach
    public void init() {
        movie = new Movie("Titanic", Rating.TEENS);
        documentary = new Documentary("Thriller", Rating.MATURE);
        tvShow = new TVShow("Friends", Rating.TEENS, 10);

        profile = new Profile("Lisa");
    }

    @Test
    public void returnsTrueWhenCurrentlyWatchingContainsContentAfterCallingStartWatchingMethod() {
        profile.startWatching(movie);
        profile.startWatching(documentary);
        profile.startWatching(tvShow);

        assertTrue(profile.getCurrentlyWatching().contains(movie));
        assertTrue(profile.getCurrentlyWatching().contains(documentary));
        assertTrue(profile.getCurrentlyWatching().contains(tvShow));
        assertEquals(profile.getCurrentlyWatching().get(0), tvShow);
    }

    @Test
    public void returnsFalseIfCurrentlyWatchingContainsContentAfterCallingFinishWatchingMethod() {
        profile.startWatching(movie);
        profile.startWatching(documentary);
        profile.startWatching(tvShow);

        profile.finishWatching(movie);
        profile.finishWatching(documentary);
        profile.finishWatching(tvShow);

        assertFalse(profile.getCurrentlyWatching().contains(movie));
        assertFalse(profile.getCurrentlyWatching().contains(documentary));
        assertFalse(profile.getCurrentlyWatching().contains(tvShow));
    }


    @Test
    public void returnsTrueWhenRecentlyWatchedContainsContentAfterCallingFinishWatchingMethod() {
        profile.startWatching(movie);
        profile.startWatching(documentary);
        profile.startWatching(tvShow);

        profile.finishWatching(movie);
        profile.finishWatching(documentary);
        profile.finishWatching(tvShow);

        assertTrue(profile.getRecentlyWatched().contains(movie));
        assertTrue(profile.getRecentlyWatched().contains(documentary));
        assertTrue(profile.getRecentlyWatched().contains(tvShow));
    }
}
