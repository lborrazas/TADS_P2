package tad;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList<String> list = new LinkedList<String>();
    @Before
    public void setUp() throws Exception {

        list.add("hola");

    }

    @Test
    public void makeEmpty() {
        list.makeEmpty();
       int size =  list.size();
        assertTrue(size==0);
    }

    @Test
    public void add() {
        list.add("juan");
        list.add("emiliano");
        int size = list.size;
        assertTrue(size == 3);
    }

    @Test
    public void remove() {

        list.add("juan");
        list.add("emiliano");
        list.add("emano");
        list.remove(3);
        int size = list.size;
        assertTrue(size == 3);
    }

    @Test
    public void get() {
    }

    @Test
    public void contains() {
       boolean bool = list.contains("hola");
       assertTrue(bool);
    }

    @Test
    public void remove1() {
        list.remove("hola");
        assertTrue(list.size == 0);

    }

    @Test
    public void addFirst() {
        list.addFirst("German");
        assertTrue(list.get(0).equals("German"));
    }


    @Test
    public void addOrder() {
        list.addOrder("mate", "juan", "german","mendi","serrana");
        assertTrue(list.size == 6);
        assertTrue(list.get(1).equals("mate"));
    }
}