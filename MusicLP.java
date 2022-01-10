package week8;
/*
 * MusicLP.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This class that stores MusicLP details and compares their details.
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

public class MusicLP implements Comparable<MusicLP> {
    Integer year;
    String artist;
    String title;
    float length;
    int tracks;

    MusicLP(Integer year, String artist, String title, float length, int tracks) {
        this.year = year;
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.tracks = tracks;
    }

    @Override
    public int compareTo(MusicLP other) {
        int result = this.artist.compareTo(other.artist);
        if (result == 0) {
            return this.year.compareTo(other.year);
        } else {
            return result;
        }
    }

    @Override
    public String toString() {
        return "MusicLP{" +
                "year=" + year +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", tracks=" + tracks +
                '}';
    }
}
