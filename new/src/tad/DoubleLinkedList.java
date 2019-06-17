package tad;



public class DoubleLinkedList<T> implements MyList<T> {

    private Node head;
    private Node tail;
    private int size;


    private class Node { //crear el nodo adentro es muuuuuy comodo
        T element;
        Node next;
        Node prev;


        public Node(T element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

    }




    public void add(T object) {
        Node aux = new Node(object, null, tail);
        if(tail != null) tail.next = aux;
        tail = aux;
        if(head == null)  head = aux;
        size++;
    }

    public void addFirst(T object){
        Node aux = new Node(object, head, null);
        if(head != null) head.prev = aux;
        head = aux;
        if(tail == null) tail = aux;
        size++;
    }

    public void remove(int position) {
        Node nodePos = head;
        for (int i = 0; i<position; i++){
            nodePos = head.next;
        }
        nodePos.prev.next = nodePos.next;
        nodePos.next.prev = nodePos.next;

        size--;
    }


    public T get(int position) {
        Node nodePos = head;
        for (int i = 0; i<position; i++){
            nodePos = head.next;
        }
        return nodePos.element;
    }
}
