package tad;
import tad.tadExceptions.EmptyQueueException;

public interface MyQueue<J> {
    void enqueue (J element);
    void dequeue() throws EmptyQueueException;
    boolean isEmpty();
    J getFirst() throws EmptyQueueException;
}
