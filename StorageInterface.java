package week8;
/*
 * StorageInterface.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * An interface that defines the structure of SortedStorageSetWithNulls.java
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

public interface StorageInterface <E> {
    boolean add(E x);               // true if it was successfully added, false otherwise

    boolean find(E x);           // true if x could be found, false otherwise

    boolean includesNull();      // true, if the storage include a null element, false otherwise

    boolean delete(E x);         // true if it was successfully deleted, false otherwise
}
