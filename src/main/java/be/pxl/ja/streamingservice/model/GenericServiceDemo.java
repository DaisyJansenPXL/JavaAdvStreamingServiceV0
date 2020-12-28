package be.pxl.ja.streamingservice.model;

public class GenericServiceDemo {
    public static void main(String[] args) {
        CountService countService = new CountService();
        System.out.println(countService.execute("abcdefghijkl"));

        ProfileService profileService = new ProfileService();
        Profile profile1 = profileService.execute(8);
        System.out.println(profile1);
    }
}
