package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Profile implements Comparable<Profile> {

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
            throw new InvalidDateException(dateOfBirth, "Date of birth", "No date of birth in future allowed.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        if (dateOfBirth == null) {
            return 0;
        }
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDateTime.now());
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


    @Override
    public int compareTo(Profile other) {
        return this.name.compareTo(other.name);
    }


    /*@Override
    public int compareTo(Profile other) { // natural sorting based on age instead of name
    return getAge() - other.getAge();*/


    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Profile profile = (Profile) o;

        return getName() != null ? getName().equals(profile.getName()) : profile.getName() == null;
    }

    @Override
    public String toString() {
        return "Profile{" + "name='" + name + "' ,age=" + getAge() + '}';
    }
}
