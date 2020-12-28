package be.pxl.ja.streamingservice.model;

public class CountService implements Service<Integer, String> {

    @Override
    public Integer execute(String arg) {
        return arg.length();
    }

}
