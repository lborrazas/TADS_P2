package tad;


import tad.tadExceptions.NodeDontExist;

import java.util.EmptyStackException;

public class Stack <J>
    implements MyStack<J> {

    private Node<J> imTop;

    public void pop() throws EmptyStackException {
        if (imTop != null) imTop = imTop.getNext();
        else throw new EmptyStackException();
    }

    public J top() throws EmptyStackException {
        if (imTop == null) throw new EmptyStackException();
        else return imTop.getValue();
    }

    public void push(J element) {
        Node<J> node = new Node<J>();
        node.setValue(element);
        if (imTop != null) {
            node.setNext(imTop);
            imTop = node;
        } else imTop = node;
    }

    public boolean isEmpty() {
    boolean empty = false;
        if (imTop == null) empty = true;
        return empty;
}

    public void makeEmpty() {
        while (imTop != null) pop();
    }

}