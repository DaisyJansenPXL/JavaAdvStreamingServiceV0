package be.pxl.ja.streamingservice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphabeticSortingProfiles {
    public static void main(String[] args) {
        List<Profile> profiles = new ArrayList<>();
        Profile p1 = new Profile("Erik");
        Profile p2 = new Profile("Sam");
        Profile p3 = new Profile("Ann");
        Profile p4 = new Profile("Ann");

        profiles.add(p1);
        profiles.add(p2);
        profiles.add(p3);
        profiles.add(p4);

        System.out.println(p3.compareTo(p4));
        System.out.println(p4.compareTo(p2));


        Collections.sort(profiles);

        System.out.println(profiles);
    }
}
