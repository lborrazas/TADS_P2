package tad;

import tad.tadExceptions.EmptyQueueException;

public interface MyDoubleQueue<J>
    {
    void enqueueLeft (J element);
    void dequeueLeft() throws EmptyQueueException;
    void enqueueRight (J element);
    void dequeueRight() throws EmptyQueueException;
    boolean isEmpty();
    public J getLeft() throws EmptyQueueException;
    public J getRight() throws EmptyQueueException;
}
