package tad;

public class SeparateChainingHashTable<K> {

    private LinkedList<Node>[] theLists;
    private int currentSize;

    public SeparateChainingHashTable(int buckets) {
        this.theLists = new LinkedList[buckets]; //ToDo nextPrime number
        for (int i = 0; i < theLists.length; i++)
            theLists[i] = new LinkedList<Node>(); //Node dont need to
        this.currentSize = 0;
    }

    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++)
            theLists[i].makeEmpty(); //ToDo makeEmpty en Arraylist (falto);
        currentSize = 0;
    }

    public boolean contains(K o) {
        boolean bool = false;
        Node node = new Node(o);
        LinkedList<Node> thisList = theLists[myHash(o.hashCode())];
        bool = thisList.contains(node);
        return bool;
    }

    public K get(K o){
        K lookingFor;
        Node node = new Node(o);
        LinkedList<Node> thisList = theLists[myHash(o.hashCode())];
        lookingFor = (K) thisList.get(node).object;
        return lookingFor;
    }

    public void insert(K o) {
        Node node = new Node(o);
        LinkedList<Node> thisList = theLists[myHash(node.key)];
        if(!thisList.contains(node)){
            thisList.addFirst(node);
            currentSize++;
        }
    }

    public LinkedList<K> getAsociatedElements(int key) {
        LinkedList<Node> thisList = theLists[myHash(key)];
        LinkedList<K> elements = new LinkedList<>();
        for (int i=0; i<thisList.size(); i++){
            Node aux = thisList.get(i);
            if (aux.key == key){   //ToDo Este es un filtro por HashVal, despues hay que hacer otro por key (Si sacamos este/?/)
                elements.add((K) aux.object);
            }
        }
        return elements;
}

    public void remove(K o){
        Node node = new Node(o);
        LinkedList<Node> thisList = theLists[myHash(o.hashCode())];
        if (thisList.contains(node)) {
            thisList.remove(node);
            currentSize--;
        }
    }

    private int myHash(int hashVal) {
        hashVal %= theLists.length;
        if (hashVal < 0) hashVal += theLists.length;
        return hashVal;
    }

    private static class Node<K> {
        K object;
        int key;

        public Node(K object) {
            this.object = object;
            this.key = object.hashCode();
        }

        public boolean equals(Object node) {
            if (node instanceof Node){
                Node temp = (Node) node;
                return this.object.equals(temp.object);
            }
            return false;
        }

        public int getKey() {
            return key;
        }
    }
    public int getCurrentSize() {
        return currentSize;
    }
}
