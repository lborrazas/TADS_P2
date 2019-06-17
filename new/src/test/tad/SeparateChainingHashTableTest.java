package tad;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeparateChainingHashTableTest {
    SeparateChainingHashTable<String> separateChainingHashTable = new SeparateChainingHashTable<>(11);

    @Test
    public void makeEmpty() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void insert() {
        separateChainingHashTable.insert("mate");
        separateChainingHashTable.insert("juan");
       // assertTrue(separateChainingHashTable.getCurrentSize() == 2);

    }

    @Test
    public void remove() {
        insert();
        separateChainingHashTable.remove("juan");
        assertTrue(separateChainingHashTable.getCurrentSize() == 1);

    }
}