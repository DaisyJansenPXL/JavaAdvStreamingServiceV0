package be.pxl.ja.streamingservice.model;

public class Documentary extends Movie {
    private String topic;

    public Documentary(String title, Rating maturityRating) {
        super(title, maturityRating);
        setGenre(Genre.DOCUMENTARY); //Objecten van de klasse Documentary moeten steeds Genre.DOCUMENTARY zijn
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public void play() {
        System.out.println("Playing Documentary " + this.getTopic());
    }

    @Override
    public void pause() {
        System.out.println("Pausing Documentary " + this.getTopic());
    }


}
