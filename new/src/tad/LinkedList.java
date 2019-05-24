package tad;

public class LinkedList<R> implements MyList<R> {
    private Node<R> first;
    int size;

    public void add(R value) {
        Node<R> node = new Node<R>(value);
        Node<R> nodeNoNext;
        if (first != null) {
            nodeNoNext = first;
            while (nodeNoNext.getNext() != null) {
                nodeNoNext = nodeNoNext.getNext();
            }
            nodeNoNext.setNext(node);
        } else first = node;
        size++;
    }

    public void remove(int position) {
        Node<R> nodeToLast = first;
        Node<R> aux = null;
        for (int i = 0; i < position - 1; i++) {
            nodeToLast = nodeToLast.getNext();
        }
        aux = nodeToLast.getNext();
        aux = aux.getNext();
        nodeToLast.setNext(aux);
        size--;
    }

    public R get(int position) {
        R aux = null;
        Node<R> nodeToPos = first;
        for (int i = 0; i < position; i++) {
            nodeToPos = nodeToPos.getNext();
        }
        aux = nodeToPos.getValue();
        return aux;
    }

    public boolean searchElement(R element) {
        boolean found = false;
        Node<R> nodeNoNext = first;
        while (nodeNoNext.getNext() != null) {
            if (nodeNoNext.getValue().equals(element)) found = true;
            nodeNoNext = nodeNoNext.getNext();
        }
        return found;
    }

    public void addFirst(R value) {
        Node<R> aux = new Node<R>();
        if (first != null) {
            aux.setValue(first.getValue());
            aux.setNext(first.getNext());
            first.setValue(value);
            first.setNext(aux);
        } else add(value);
        size++;
    }

    public int size() {
        return size;
    }

    public void addOrder(R... values) {
        for (int i = 0; i < values.length; i++) {
            add(values[i]);
        }
    }
}
