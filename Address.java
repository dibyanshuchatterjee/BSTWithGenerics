package week8;
/*
 * Address.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This class that stores Address details and compares their details.
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

public class Address implements Comparable<Address> {
    Integer houseNumber;
    String streetName;
    String nameOfTown;
    String state;
    int zipCode;

    Address(Integer houseNumber, String streetName, String nameOfTown, String state, int zipCode) {
        this.houseNumber = houseNumber;
        this.nameOfTown = nameOfTown;
        this.state = state;
        this.streetName = streetName;
        this.zipCode = zipCode;
    }

    @Override
    public int compareTo(Address other) {
        int result = this.state.compareTo(other.state);
        if (result == 0) {
            int townResult = this.nameOfTown.compareTo(other.nameOfTown);
            if (townResult == 0) {
                return houseNumber.compareTo(other.houseNumber);
            } else {
                return townResult;
            }
        }
        return result;

    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", streetName='" + streetName + '\'' +
                ", nameOfTown='" + nameOfTown + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
