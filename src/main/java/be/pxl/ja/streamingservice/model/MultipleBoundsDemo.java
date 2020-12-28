package be.pxl.ja.streamingservice.model;

import java.util.ArrayList;
import java.util.List;

public class MultipleBoundsDemo {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        Movie brotherBear = new Movie("Brother Bear", Rating.LITTLE_KIDS);
        brotherBear.setDuration(125);
        Movie theLionKing = new Movie("The Lion King", Rating.LITTLE_KIDS);
        brotherBear.setDuration(135);

        List<Documentary> documentaries = new ArrayList<>();
        Documentary planetEarth = new Documentary("Planet Earth", Rating.OLDER_KIDS);
        planetEarth.setDuration(200);
        Documentary ourOcean = new Documentary("Our Ocean", Rating.OLDER_KIDS);
        ourOcean.setDuration(140);

        startPlayableContent(ourOcean);
        startPlayableContent(brotherBear);
    }

    public static <T extends Content & Playable> void startPlayableContent(T playableContent) {
        playableContent.play();
        System.out.println("This content will be playing for " + playableContent.getDuration() + " minutes.");
    }
}
