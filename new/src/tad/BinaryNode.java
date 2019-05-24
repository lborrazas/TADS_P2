package tad;

public class BinaryNode<K extends Comparable<K>,T>{
    K key;
    public T data;

    public BinaryNode<K,T> leftChild;
    public BinaryNode<K,T> rightChild;
}
