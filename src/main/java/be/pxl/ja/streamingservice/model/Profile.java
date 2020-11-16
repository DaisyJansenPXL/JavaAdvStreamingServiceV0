package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.time.Period;

public class Profile {

    private String name;
    private LocalDate dateOfBirth;

    public Profile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        LocalDate date = LocalDate.now();

        return Period.between(dateOfBirth, date).getYears();
    }

    public boolean allowedToWatch(Content content) {
        if (dateOfBirth != null) {
            return content.getMaturityRating().getMinimumAge() < getAge();
        }
        return false;
    }
}
