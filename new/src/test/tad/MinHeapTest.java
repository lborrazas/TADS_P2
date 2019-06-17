package tad;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {
    MinHeap<Integer,String> colaConPrioridad = new MinHeap<>(10);
    @Test
    public void insert() {
        colaConPrioridad.insert(10,"elisa");
        colaConPrioridad.insert(2,"mate");
        assertTrue(colaConPrioridad.getSize() == 2);
    }

    @Test
    public void isEmpty() {

    }


    @Test
    public void getMin() {
        insert();
        assertTrue(colaConPrioridad.getMin().equals("mate"));
    }

    @Test
    public void makeEmpty() {
        insert();
        colaConPrioridad.makeEmpty();
        assertTrue(colaConPrioridad.getSize() == 0);
    }
}