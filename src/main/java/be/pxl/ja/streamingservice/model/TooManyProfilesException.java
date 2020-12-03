package be.pxl.ja.streamingservice.model;

public class TooManyProfilesException extends RuntimeException {

    public TooManyProfilesException() {
        super("Limit of profiles has been reached. ");
    }
}
