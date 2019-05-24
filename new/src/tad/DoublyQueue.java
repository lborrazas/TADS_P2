package tad;

import tad.tadExceptions.EmptyQueueException;

public class DoublyQueue<J>
        implements MyDoubleQueue<J>  {


     class Node { //crear el nodo adentro es muuuuuy comodo
        J element;
        Node next;
        Node prev;

        public Node(J element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public void setNext(Node node){ this.next = node;}
        public Node getNext(){
            return this.next;
        }
        public void setPrev(Node node){this.prev = node;}
        public Node getPrev(){
            return this.prev;
        }

    }

    private Node head;
    private Node tail;
    private int size;



    public void enqueueLeft(J element) {
        Node node = new Node(element,null,null);
        if(head == null) {
            head = node;
            tail = node;
        }
        else{
            tail.prev = node;
            node.next = tail;
            tail = node;
        }
        size++;
    }

    public void dequeueLeft() throws EmptyQueueException {
        if(tail == null) throw new EmptyQueueException();
        tail = tail.next;
        tail.prev = null;
        size--;
    }

    public void enqueueRight(J element) {
        Node node = new Node(element, null, null);
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            head.next = node;
            node.prev = head;
            head = node;
        }
        size++;
    }


    public void dequeueRight() throws EmptyQueueException {
        if(head == null) throw new EmptyQueueException();
        head = head.prev;
        head.next = null;
        size--;
    }


    public boolean isEmpty() {
        boolean empty = false;
        if(head == null) empty = true;
        return empty;
    }

    public J getLeft() throws EmptyQueueException {
        J aux = null;
        if(tail == null) throw new EmptyQueueException();
        aux = tail.element;
        return aux;
    }

    public J getRight() throws EmptyQueueException {
        J aux = null;
        if(head== null) throw new EmptyQueueException();
        aux = head.element;
        return aux;
    }
}
