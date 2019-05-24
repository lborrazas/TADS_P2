package tad;

public class Node <J>{
    private J value;
    private Node next;
    public Node(J value){
        this.value = value;
        next = null;
    }
    public Node(){
        this.value = null;
        next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {

        return next;
    }

    public void setValue(J value) {
        this.value = value;
    }


    public J getValue() {
        return value;
    }

}
