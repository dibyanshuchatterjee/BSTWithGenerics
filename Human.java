package week8;
/*
 * Human.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This class that stores Human details and compares their details.
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

import java.util.Date;

public class Human implements Comparable<Human> {
    Date dateOfBirth;
    String firstName;
    String userId;

    Human(Date dateOfBirth, String firstName, String userId) {
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.userId = userId;
    }

    @Override
    public int compareTo(Human other) {
        int result = this.dateOfBirth.compareTo(other.dateOfBirth);
        if (result == 0) {
            return (this.firstName.compareTo(other.firstName));
        } else {
            return result;
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "dateOfBirth=" + dateOfBirth +
                ", firstName='" + firstName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
