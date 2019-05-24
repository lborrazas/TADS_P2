package tad;

import java.util.*;

import tad.tadExceptions.*;

public class DoublyCircledList<J> implements MyList<J> {

    private Node start;
    private int size;


    public DoublyCircledList() {
        size = 0;
    }

    private class Node { //crear el nodo adentro es muuuuuy comodo
        J element;
        Node next;
        Node prev;

        public Node(J element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public void setNext(Node node){
            this.next = node;
        }

        public Node getNext(){
            return this.next;
        }

        public void setPrev(Node node){
            this.prev = node;
        }

        public Node getPrev(){
            return this.prev;
        }

    }

    public void add(J object) {
        Node aux = new Node(object, start, null);
        if (start != null) {
            aux.prev = start.prev;
            start.prev.next = aux;
            start.prev = aux;
            if (size == 1) start.next = aux;
        } else {
            start = aux;
            aux.prev = aux;
            aux.next = aux;
        }
        size++;
    }

    public void remove(int position) throws NodeDontExist {
        if (size == 0) throw new NodeDontExist();
        Node nodePos = start;
        for (int i = 0; i < position; i++) {
            nodePos = nodePos.next;
        }
        nodePos.next.prev = nodePos.prev;
        nodePos.prev.next = nodePos.next;
        if (size == 1) start = null;
        size = size - 1;

    }


    public J get(int position) throws NodeDontExist {
        if (size == 0) throw new NodeDontExist();
        Node nodePos = start;
        for (int i = 0; i < position; i++) {
            nodePos = nodePos.next;
        }
        return nodePos.element;
    }

    public void setStart(int position) throws NodeDontExist {
        if (size == 0) throw new NodeDontExist();
        Node nodePos = start;
        for (int i = 0; i < position; i++) {
            nodePos = nodePos.next;
        }
        this.start = nodePos;
    }

    public int Size() {
        return size;
    }

    public int searchValue(J value)
            throws NodeDontExist {
        int position = 0;
        Node nodeValue = start;
        boolean found = false;
        while (nodeValue.element != value && position < size) {
            nodeValue = nodeValue.next;
            position++;
            if (nodeValue.element == value) found = true;
        }
        if (!found) throw new NodeDontExist();
        return position;
    }

    public boolean foundValue(J value){
        Node nodeValue = start;
        int position =0;
        boolean found = false;
        while (nodeValue.element != value && position < size) {
            nodeValue = nodeValue.next;
            position++;
            if (nodeValue.element == value) found = true;
        }
        return found;
    }


    public void swithcerooNode2(J value, int n)
            throws NodeDontExist {
        int s = searchValue(value);
        Node switchNode = start;
        Node placeToSwtich;
        for (int i = 0; i < s; i++) {
            switchNode = switchNode.next;
        }
        placeToSwtich = switchNode;

        for (int j = 0; j < n; j++) {
            placeToSwtich = placeToSwtich.next;
        }

        swap(switchNode.prev.next, placeToSwtich.prev.next);
    }

    void swap(Node left, Node right) {
        if (Objects.equals(left, right)) return;
        Node tmp = left.getNext();
        left.setNext(right.getNext());
        right.setNext(tmp);
        if (!Objects.isNull(left.getNext()))
            left.getNext().setPrev(left);
        if (!Objects.isNull(right.getNext()))
            right.getNext().setPrev(right);
        tmp = left.getPrev();
        left.setPrev(right.getPrev());
        right.setPrev(tmp);
        if (!Objects.isNull(left.getPrev())) {
            left.getPrev().setNext(left);
        } else {
            this.start = left;
        }
        if (!Objects.isNull(right.getPrev())) {
            right.getPrev().setNext(right);
        } else {
            this.start = right;
        }
    }

    public void addOrder(J... values){
        for (int i=0; i<values.length; i++ ){
            add(values[i]);
        }
    }

    public void append(DoublyCircledList<J> second){
        for (int i=0; i<second.size; i++){
           try {
               add(second.get(i));
           }catch(NodeDontExist var){
               System.out.println("Something went wrong at append");
           }
        }
    }

    public void appendNoCopy(DoublyCircledList<J> second){
        for (int i=0; i<second.size; i++){
            try {
                if(!foundValue(second.get(i))) add(second.get(i));
            }catch(NodeDontExist var){
                System.out.println("Something went wrong at appendNoCoppy");
            }
        }
    }

    public void butNotBoth(DoublyCircledList<J> second){
        for (int i=0; i<second.size; i++){
            try {
                if(!foundValue(second.get(i))) add(second.get(i));
                else remove(searchValue(second.get(i)));
            }catch(NodeDontExist var){
                System.out.println("Something went wrong at butNotBoth");
            }
        }
    }


}



