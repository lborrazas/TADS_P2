package tad;

import org.junit.Before;
import org.junit.Test;
import tad.tadExceptions.UnderflowException;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer, String> myTree = new BinarySearchTree<>();


    @Before
    @Test
    public void insert() {
        myTree.insert(10, "First Data");
        myTree.insert(15, "Some Data");
        myTree.insert(5, "Some Data 2");
        myTree.insert(24, "Max Data");
        myTree.insert(13, "replace Data");
        myTree.insert(14, "Some Data 3");
        myTree.insert(3, "Some Data 4");
        myTree.insert(1, "Min Data");
        myTree.insert(2, "Some Data 5");
        myTree.insert(4, "Some Data 6");

        assertFalse(myTree.isEmpty());
        assertEquals(4, (int) myTree.getRoot().leftChild.leftChild.rightChild.key);
    }

    @Test
    public void isEmpty() {
        myTree.insert(9, "SecondData");
        System.out.println(myTree.contains(2));
    }

    @Test
    public void makeEmpty() {
        myTree.makeEmpty();
        assertTrue(myTree.isEmpty());
    }

    @Test
    public void contains() {
        assertTrue(myTree.contains(5));
    }

    @Test
    public void findMin() {
        String temp = null;
        try {
            temp = myTree.findMin();
        } catch (UnderflowException ignored) {
        }
        assertEquals("Min Data", temp);
    }


    @Test
    public void findMax() {
        String temp = null;
        try {
            temp = myTree.findMax();
        } catch (UnderflowException var) { //ToDo an exception handle.
        }
        assertEquals("Max Data", temp);
    }

    @Test
    public void remove() {

        assertEquals(15, (int) myTree.root.rightChild.key);
        try {
            myTree.remove(15);
        } catch (UnderflowException var) {
            System.out.println("ops");
        }
        assertEquals(24, (int) myTree.root.rightChild.key);
        assertFalse(myTree.contains(15));
    }

    @Test
    public void find() {
        String aux = null;
        try {
            aux = myTree.find(2);
        } catch (UnderflowException ignored) {
        }
    }

    @Test
    public void size() {
        Integer temp = myTree.size();
    }

    @Test
    public void countLeafs() {
        System.out.println(myTree.countLeafs());
        assertEquals(4, myTree.countLeafs());
    }

    @Test
    public void countCompleteElements() {
        assertEquals(3, myTree.countCompleteElements());
    }

    @Test
    public void preOrder() {
        LinkedList<String> values = new LinkedList<>();
        myTree.inOrder(values);
        // for (int i = 0; i < values.size(); i++) System.out.println(values.get(i));
        assertEquals("Max Data", values.get(values.size - 1));
        assertEquals("Min Data", values.get(0));
    }

    @Test
    public void height() {
        int aux = myTree.height();
        System.out.println(aux);
        assertEquals(5, aux);
    }

    @Test
    public void lvlOrder() {
        LinkedList<String> values = new LinkedList<>();
        myTree.levelOrder(values);
        for (int i = 0; i < values.size(); i++) System.out.println(values.get(i));

    }


}

