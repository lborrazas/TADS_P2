package tad;

import tad.tadExceptions.UnderflowException;

    public class BinarySearchTree<K extends Comparable<K>, J>
            implements MyTree<K, J> {

        public BinaryNode<K, J> root;
        private int size;

        BinaryNode<K, J> getRoot() {
            return root;
        }

        public void makeEmpty() {
            root = null;
        }

    public boolean isEmpty() {
        return (root == null);
    }

    public boolean contains(K key) {
        return contains(key, root);
    }

    public J findMin()
            throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return findMin(root).data;
    }

    public J findMax()
            throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return findMax(root).data;
    }

    public void insert(K key, J data) {
        root = insert(key, data, root);
    }

    public void remove(K key)
            throws UnderflowException {
        root = remove(key, root);
    }

    public J find(K key)
            throws UnderflowException {
        return find(key, root).data;
    }

    public void inOrder(MyList<J> valuesTemp) {
        inOrder(root, valuesTemp);
    }

    public int size() {
        int temp = 0;
        size(root, temp);
        return temp;
    }

    public int countLeafs() {
        Integer temp = 0;
        temp = countLeafs(root, temp);
        return temp;
    }

    public int countCompleteElements() {
        Integer temp = 0;
        temp = countCompleteElemets(root, temp);
        return temp;
    }

    public int height() {
        int lHeight = 0;
        int rHeight = 0;
        int aux = height(root, lHeight, rHeight);
        return aux;
    }

    private boolean contains(K key, BinaryNode<K, J> t) {
        if (t == null) return false; // Va antes de toodo para evitar nullpointer exception
        int compareResult = key.compareTo(t.key);
        if (compareResult < 0) return contains(key, t.leftChild);
        else if (compareResult > 0) return contains(key, t.rightChild);
        else return true; //Match
    }

    private BinaryNode<K, J> findMin(BinaryNode<K, J> t) {
        if (t == null) return null;//Siempre hay que primero tener en cuenta este caso
        else {
            if (t.leftChild != null) return findMin(t.leftChild);
            return t;
        }
    }

    private BinaryNode<K, J> findMax(BinaryNode<K, J> t) { // vamo a hacerlo con while
        if (t == null) return null;
        while (t.rightChild != null) t = t.rightChild;
        return t;
    }

    private BinaryNode<K, J> insert(K key, J data, BinaryNode<K, J> t) { //recursiva de alteracion de root;
        if (t == null) {
            BinaryNode<K, J> aux = new BinaryNode<>();
            aux.key = key;
            aux.data = data;
            return aux; //cortamo el flujo wei
        }
        int compareResult = key.compareTo(t.key);
        if (compareResult < 0) t.leftChild = insert(key, data, t.leftChild);
        else if (compareResult > 0)  t.rightChild = insert(key, data, t.rightChild); //va a seguir un trabajo en algun lado pero no me altera mi t
        else t.data = data;
        return t; //queremos que root siempre sea root salvo cuando es nula que la queremos en 0
    }

    private BinaryNode<K, J> remove(K key, BinaryNode<K, J> t) //recursiva de alteracion de root;
            throws UnderflowException {
        if (t == null) throw new UnderflowException();
        int compareResult = key.compareTo(t.key);
        if (compareResult < 0) t.leftChild = remove(key, t.leftChild);
        else if (compareResult > 0) t.rightChild = remove(key, t.rightChild);
        else if (t.leftChild != null && t.rightChild != null) { //two Children este es el remove complejo
            t.data = findMin(t.rightChild).data; //buscamos un valor minimo en el derecho (no va a tener hijo izq)
            t.key = findMin(t.rightChild).key;
            t.rightChild = remove(t.key, t.rightChild);//removemos ese valor de la derecha con el codigo siguiente
        } else
            t = (t.leftChild != null) ? t.leftChild : t.rightChild;//como tiene uno solo o ninguno va a  dar ese valor :)
        return t;
    }

    private BinaryNode<K, J> find(K key, BinaryNode<K, J> t) //recursiva de retorno valor encontrado
            throws UnderflowException {
        if (t == null) throw new UnderflowException();
        int compareResult = key.compareTo(t.key);
        if (compareResult < 0) return find(key, t.leftChild);
        else if (compareResult > 0) return find(key, t.rightChild); //no comerse los return
        else
            return t; //este es el t que cuando encuentre va a ir retornando whole thing back ...TODO no seria mejor acumularlo?
    }

    private void inOrder(BinaryNode<K, J> root, MyList<J> valuesTemp) { //recursiva de acumulador
        if (root.leftChild != null) inOrder(root.leftChild, valuesTemp);
        valuesTemp.add(root.data); //HAY QUE CAMBIAR
        if (root.rightChild != null) inOrder(root.rightChild, valuesTemp);
    }

    private void size(BinaryNode<K, J> t, int size) { //recursiva de acumulador
        if (t == null) return;
        size++;
        if (t.leftChild != null) size(t.leftChild, size);
        if (t.rightChild != null) size(t.rightChild, size);
    }

    private Integer countLeafs(BinaryNode<K, J> t, Integer leafs) {  //recursiva de acumulador requiere mandar el acumulador
        if (t != null && t.rightChild == null && t.leftChild == null) {
            leafs++;
            return leafs;
        }
        if (t.leftChild != null) leafs = countLeafs(t.leftChild, leafs);
        if (t.rightChild != null) leafs = countLeafs(t.rightChild, leafs);
        return leafs;
    }

    private Integer countCompleteElemets(BinaryNode<K, J> t, Integer comp) {
        if (t != null && t.leftChild != null && t.rightChild != null) {
            comp++;
            System.out.println(comp);
        }
        if (t.leftChild != null) comp = countCompleteElemets(t.leftChild, comp);
        if (t.rightChild != null) comp = countCompleteElemets(t.rightChild, comp);
        return comp;
    }

    private int height(BinaryNode<K, J> t, int lHeight, int rHeight) {
        if (t == null) return 0; //importante para reestablecer los valores
        lHeight = height(t.leftChild, lHeight, rHeight);
        rHeight = height(t.rightChild, lHeight, rHeight);
        System.out.println(lHeight + " " + rHeight + " at " + t.key);
        if (lHeight > rHeight) return lHeight + 1;
        else return rHeight + 1;
    }

    public void levelOrder(MyList<J> tempValues) {
        int height = height();
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i, tempValues);
        }
    }



    void printGivenLevel (BinaryNode<K,J> root ,int lvl, MyList<J> values) {
        if (root == null)
            return;
        if (lvl == 1)
            values.add(root.data);
        else if (lvl > 1)
        {
            printGivenLevel(root.leftChild, lvl-1, values);
            printGivenLevel(root.rightChild, lvl-1, values);
        }
    }


}




