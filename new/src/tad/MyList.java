package tad;

import tad.tadExceptions.NodeDontExist;

public interface MyList<T> {
    void add(T object);
    void remove(int position)throws NodeDontExist;
    T get(int position) throws NodeDontExist;

}
