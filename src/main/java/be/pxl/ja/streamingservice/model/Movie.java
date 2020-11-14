package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

import static java.lang.Math.abs;

public class Movie extends Content implements Playable {
    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;
    public static final int LONG_PLAYING_TIME = 125;

    public Movie(String title, Rating maturityRating) {
        super(title, maturityRating);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void play() {
        System.out.println("Playing " + this);
    }

    @Override
    public void pause() {
        System.out.println("Pausing " + this);
    }

    public boolean isLongPlayingTime() {
        return duration >= LONG_PLAYING_TIME;
    }

    public String getPlayingTime() {
        int playingTime = duration;
        int hours = 0;
        int minutes = 0;

        if (playingTime == 0) {
            return "?";
        }

        minutes = playingTime % 60;
        hours = (playingTime - minutes) / 60;

        StringBuilder sb = new StringBuilder();
        if (hours != 0) {
            sb.append(hours).append(" h");
        }
        if (hours != 0 && minutes != 0) {
            sb.append(" ");
        }
        if (minutes != 0) {
            sb.append(minutes).append(" min");
        }

        return sb.toString();
    }

    public void setDuration(int duration) {
        this.duration = abs(duration);
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        if (releaseDate != null) {
            builder.append(" (").append(releaseDate.getYear()).
                    append(")");
            }
        return builder.toString();
        }
}
