package tad;

public class MinHeap<K extends Comparable<K>, J> {
    private int size;
    private Node<K,J>[] array;
    private boolean isMinHeap = true;

    private static class Node<K,J> {
        K priority;
        J data;

        public Node(K priority, J data) {
            this.priority = priority;
            this.data = data;
        }
    }

    public MinHeap(int capacity) {
        array = (Node<K,J>[]) new Node<?,?>[capacity];
        size = 0;
    }

    public void insert(K priority, J capacity) {
        Node<K, J> node = new Node<K,J>(priority, capacity);//Ends  con el array[0] con el valor de pivot
        if (size == 0) {
            array[1] = node;
            size++;
            return;
        }
        int placement = ++size; //Size increases and then assigned to placement!!All in one
        for (array[0] = node; array[0].priority.compareTo(array[placement / 2].priority) < 0; placement /= 2) //placement = placement/2
            array[placement] = array[placement / 2];
        array[placement] = node;
    }//the placement hole moves until we find the right spot.. since we save the node in a temp
    //we get the ability to place all existing values to the placement spot without loosing our true value.

    public boolean isEmpty(){
        return array[1]==null;
    }

    public boolean contains(J data){
        for(int i =0; i<array.length; i++) {
            if (array[i] != null) {
                if (array[i].data.equals(data)) {
                    return true;
                }
            }
        }
        return false;
    }

    public J getMin(){
        if(isMinHeap)return array[1].data;
        return null;
    }

    public void makeEmpty(){
        size =0;
    }

    public J deleteMin(){
        J minItem = getMin();
        array[1] = array[size--]; //First array is assigned and then size is decremented, important!
        // Bare in mind we place our last item in the first place to make easier the compare to;
        percolateDown(1);
        return  minItem;
    }

    private void percolateDown(int emptySpace) { //Could be done with swap or better with while but its great with for
        int child; //place of left child that we will compare to our last value to fill the emptySpace
        Node<K,J> tmp = array[emptySpace];
        for (; emptySpace * 2 <= size; emptySpace = child) {
            child = emptySpace * 2; //first of all initiate the variable we are going to use;
            if (child != size && array[child + 1].priority.compareTo(array[child].priority) < 0) child++;
            //first we compare the child and then we chose one to make possible swap.
            if (array[child].priority.compareTo(tmp.priority) < 0) array[emptySpace] = array[child];
            else break; // if we dont get inside the  ifs then stop motion.
        }
        array[emptySpace] = tmp; //once emptySpace is where it should be then we give him back his value
    }

    public int getSize() {
        return size;
    }
}
