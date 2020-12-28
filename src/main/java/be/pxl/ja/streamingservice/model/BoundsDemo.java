package be.pxl.ja.streamingservice.model;

import java.util.ArrayList;
import java.util.List;

public class BoundsDemo {

    //Upper bound wildcard
    public static void deleteMovie(List<? extends Movie> movieList, Movie movie) {
        movieList.remove(movie);
    }

    //Lower bound wilccard
    public static void addDocumenatry(List<? super Movie> movieList) {
        movieList.add(new Documentary("Hunt for Red October", Rating.OLDER_KIDS));
    }

    //Unbounded wildcard
    public static void printAll(List<?> list) {
        System.out.println("Number of items: " + list.size());
        for (Object item : list) {
            System.out.println(item);
        }
        System.out.println("++++++++++++++++++++++++++++++");
    }

    public static void main(String[] args) {
        List<Content> contentList = new ArrayList<>();
        List<Movie> movieList = new ArrayList<>();
        List<Documentary> documentaryList = new ArrayList<>();

        addDocumenatry(contentList);
        addDocumenatry(movieList);

        printAll(contentList);
        printAll(movieList);

        Movie movie = movieList.get(0);
        deleteMovie(movieList, movie);
        printAll(movieList);
    }
}
