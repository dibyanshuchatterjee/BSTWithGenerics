package week8;
/*
 * Test.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An class that tests the implementation of BST.
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

public class Test {
    static public <T extends Comparable<T>> void testIt(T[] toInsert) {

        /*
         * this function sends values to the SortedStorageSetWithNulls class
         *
         */
        SortedStorageSetWithNulls<T> aStorage = new SortedStorageSetWithNulls<>();
        for (T t : toInsert) System.out.println("	add(" + t + "): " + aStorage.add(t));
        for (T t : toInsert) System.out.println("	find(" + t + "): " + aStorage.find(t));
        System.out.println("	" + aStorage);
        System.out.println("---------------------------------------");
        for (T t : toInsert) System.out.println("delete(" + t + "): " + aStorage.delete(t));
        System.out.println("	" + aStorage);
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) throws ParseException {
        Human[] humans = new Human[5];
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        System.out.println("Storing the information of People");
        for (int i = 0; i < 4; i++) {
            String[] storeDates = {"20101224", "20080627", "20121212", "20190527"};
            Date mydate = dateFormat.parse(storeDates[i]);
            String[] containsName = {"Sam", "Akash", "Brad", "Angelina"};
            String[] containsID = {"S123", "A456", "B789", "AN123"};
            humans[i] = new Human(mydate, containsName[i], containsID[i]);
        }
        testIt(humans);

        MusicLP[] songs = new MusicLP[5];
        System.out.println("Storing the information of Music Albums");
        Integer[] toStoreYear = {2012, 2020, 2010, 2005, 2021};
        String[] theArtist = {"Pitbull", "Shakira", "Skrillex", "ArRahman", "Beiber"};
        String[] songTitle = {"Gasolina", "waka waka", "purple lambrgini", "jai ho", "baby"};
        float[] storeLength = {1.5f, 2.2f, 3.5f, 5.5f, 1.8f};
        int[] storesTrack = {3, 5, 7, 8, 6};
        for (int i = 0; i < 5; i++) {
            songs[i] = new MusicLP(toStoreYear[i], theArtist[i], songTitle[i], storeLength[i], storesTrack[i]);
        }
        testIt(songs);

        Address[] adresses = new Address[5];
        System.out.println("Storing the information of house addresses");
        Integer[] houseNumber = {23, 50, 43, 34};
        String[] streetName = {"John Street", "River Street", "Harrison", "Kailashpuri"};
        String[] nameOfTown = {"Henrietta", "Greater Rochester", "New Ark", "Mughalsarai"};
        String[] state = {"new york", "arizona", "new jersey", "Uttar pradesh"};
        int[] zip = {14623, 71234, 45332, 23210};
        for (int i = 0; i < 4; i++) {
            adresses[i] = new Address(houseNumber[i], streetName[i], nameOfTown[i], state[i], zip[i]);
        }
        testIt(adresses);
        String[] randomStrings = {"abc", "def", "ghi"};
        Integer[] randomIntegers = {1, 2, 3};
        testIt(randomStrings);
        testIt(randomIntegers);
    }
}

