package tad;

import tad.tadExceptions.UnderflowException;

public interface MyTree<K extends Comparable,T> {
    T find(K key)throws UnderflowException;
    void insert (K key, T data);
    void remove (K key) throws UnderflowException;
    int size();
}
