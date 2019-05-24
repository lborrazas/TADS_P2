package tad;

import tad.tadExceptions.EmptyQueueException;

public class Queue<J> implements MyQueue<J> {
    private Node<J>  head;
    private Node<J> tail;
    private int size;


    public void enqueue(J element) {
        Node<J> node = new Node<>();
        node.setValue(element);
        if(tail == null) {
            tail = node;
            head = node;
        }
        else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void dequeue() throws EmptyQueueException {
        if(head == null) throw new EmptyQueueException();
        else head = head.getNext();
        size--;
    }

    public boolean isEmpty() {
        boolean aux = false;
        if (head == null) aux = true;
        return aux;
    }

    public J getFirst() throws EmptyQueueException {
        J aux;
        if(head == null) throw new EmptyQueueException();
        aux = head.getValue();
        return aux;

    }
}
