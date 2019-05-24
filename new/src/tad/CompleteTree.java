package tad;

import java.util.ArrayList;

public class CompleteTree<K extends Comparable<K>, J> {
    private int size;
    private ArrayList<Node> array;
    private Node root;

    private class Node{
        K priority;
        J data;

        public Node(K priority,J data){
            this.priority = priority;
            this.data = data;
        }
    }

    public CompleteTree(int capacity){
        array = new ArrayList<Node>(capacity);
        size = 0;

    }


    public void insert(K priority, J capacity) {
        Node node = new Node(priority, capacity);
        if(size == 0)array.add(node);
        array.add(0,node);
        for(node)


    }


}
