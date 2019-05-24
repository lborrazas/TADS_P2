package tad;

import tad.tadExceptions.EmptyQueueException;

public class PriorityQueue<J>
    implements MyPriorityQueue<J>{

    private Node<J> low;
    private Node<J> normal;
    private Node<J>  high;
    int size;

    public void insert(J element, Priority prioridad) {
        switch(prioridad){
            case LOW: enqueue(element);
            break;
            case NORMAL: enqueueNormal(element);
            break;
            case HIGH: enqueueHigh(element);
            break;
        }
    }

    public void enqueue(J element) {
        Node<J> node = new Node<>();
        node.setValue(element);
        if(low == null) low = node;
        else{
            low.setNext(node);
            low = node;
        }
        size++;
    }

    public void enqueueNormal(J element){
        Node<J> node = new Node<>();
        node.setValue(element);
        if(normal == null) normal = node;
        else{
            normal.setNext(node);
            normal = node;
        }
        size++;
    }

    public void enqueueHigh(J element){
        Node<J> node = new Node<>();
        node.setValue(element);
        if(high == null) high = node;
        else{
            high.setNext(node);
            high = node;
        }
        size++;
    }

    public void dequeue() throws EmptyQueueException {
        if(high != null) high = high.getNext();
        else if(normal != null) normal = normal.getNext();
        else if(low != null) low = low.getNext();
        if(high == null && normal == null && low == null)throw new EmptyQueueException();
    }


    public boolean isEmpty() {
        boolean empty = false;
        if(high == null && normal == null && low == null) empty = true;
        return empty;
    }

    public J getFirst() throws EmptyQueueException {
        J aux = null;
        if(high != null) aux = high.getValue();
        else if(normal != null) aux = normal.getValue();
        else if(low != null) aux = low.getValue();
        if(high == null && normal == null && low == null)throw new EmptyQueueException();
        return aux;
    }
}
