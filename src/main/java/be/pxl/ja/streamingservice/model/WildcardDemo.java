package be.pxl.ja.streamingservice.model;

import java.util.ArrayList;
import java.util.List;

public class WildcardDemo {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        Movie brotherBear = new Movie("Brother Bear", Rating.LITTLE_KIDS);
        brotherBear.setDuration(125);
        Movie theLionKing = new Movie("The Lion King", Rating.LITTLE_KIDS);
        brotherBear.setDuration(125);
        movies.add(brotherBear);
        movies.add(theLionKing);
        System.out.println(totalDuration(movies));

        List<Documentary> documentaries = new ArrayList<>();
        Documentary planetEarth = new Documentary("Planet Earth", Rating.OLDER_KIDS);
        planetEarth.setDuration(200);
        Documentary ourOcean = new Documentary("Our Ocean", Rating.OLDER_KIDS);
        planetEarth.setDuration(140);

        System.out.println(totalDuration(documentaries));
    }

    public static int totalDuration(List<? extends Movie> movies) {
        int totalDuration = 0;
        for (Movie movie : movies) {
            totalDuration += movie.getDuration();
        }
        return totalDuration;
    }
}
