package tad;

public class LinkedList<R> implements MyList<R> {
    int size;
    private Node<R> first;

    public void makeEmpty() {
        first = null;
        size = 0;
    }

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
        for (int i = 0; i < position; i++) { //wrong -1 we are talking about pos not size
            nodeToLast = nodeToLast.getNext();
        }
        if (!(position + 1 == size)) { //if position is not the last at the arrayList
            aux = nodeToLast.getNext();
            aux = aux.getNext();
            nodeToLast.setNext(aux);
        } else nodeToLast.setNext(null);
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

    public boolean contains(R element) { // TODO CHECKER...
        boolean found = false;
        Node<R> nodeNoNext = first; //We never checked this first case (amazing)
        if (first != null) {
            if(first.getValue().equals(element))return true;
            if (nodeNoNext.getValue().equals(element)) {
                return true;
            }

            if (first.getNext() != null) while (nodeNoNext.getNext() != null) {
                if (nodeNoNext.getValue().equals(element)) {
                    found = true;
                    break;
                }
                nodeNoNext = nodeNoNext.getNext();
            }
        }
        return found;
    }


    public R get(R element) { // TODO CHECKER...
        R found = null;
        Node<R> nodeNoNext = first; //We never checked this first case (amazing)
        if (first != null) {
            if(first.getValue().equals(element))return first.getValue();
            if (nodeNoNext.getValue().equals(element)) {
                return nodeNoNext.getValue();
            }

            if (first.getNext() != null) while (nodeNoNext.getNext() != null) {
                if (nodeNoNext.getValue().equals(element)) {
                    found = nodeNoNext.getValue();
                    break;
                }
                nodeNoNext = nodeNoNext.getNext();
            }
        }
        return found;
    }

    public void remove(R element) { //TODO CHECKER...
        Node<R> nodeToLast = first;
        if (first.getValue().equals(element)) {
            if (first.getNext() != null) first = first.getNext();
            else first = null;
            size--;
        }
        Node<R> aux = null;
        while (nodeToLast.getNext() != null) {
            if (nodeToLast.getValue().equals(element)) {
                nodeToLast = nodeToLast.getNext();
                size--;
                break;
            }
        }
    }

    public void addFirst(R value) {
        Node<R> aux = new Node<R>(value);
        if (first != null) {
            aux.setNext(first);
            first = aux;
            size++;
        } else add(value);
    }

    public int size() {
        return size;
    }

    public void addOrder(R... values) {
        for (R value : values) {
            add(value);
        }
    }
}
