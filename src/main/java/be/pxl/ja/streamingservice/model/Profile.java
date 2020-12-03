package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Profile {

    private String name;
    private LocalDate dateOfBirth;
    private List<Content> recentlyWatched = new LinkedList<>();
    private List<Content> currentlyWatching = new LinkedList<>();

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
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new InvalidDateException(dateOfBirth, "Date of birth", "Must be before date of today");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        LocalDate date = LocalDate.now();

        return Period.between(dateOfBirth, date).getYears();
    }

    public List<Content> getRecentlyWatched() {
        return recentlyWatched;
    }

    public List<Content> getCurrentlyWatching() {
        return currentlyWatching;
    }

    public boolean allowedToWatch(Content content) {
        if (dateOfBirth != null) {
            return content.getMaturityRating().getMinimumAge() < getAge();
        }
        return false;
    }

    public void startWatching(Content content) {
        if (!currentlyWatching.contains(content)) {
            currentlyWatching.add(0, content);
        }
    }

    public void finishWatching(Content content) {
        if (currentlyWatching.contains(content)) {
            Iterator<Content> contentIterator = currentlyWatching.iterator();
            while (contentIterator.hasNext()) {
                Content contentInList = contentIterator.next();
                if (contentInList == content) {
                    contentIterator.remove();
                    recentlyWatched.add(content);
                }
            }
        }
    }
}
