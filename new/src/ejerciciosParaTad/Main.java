package ejerciciosParaTad;

import tad.*;
import tad.tadExceptions.NodeDontExist;

public class Main {

    public static LinkedList<String> game(int m, DoublyCircledList<String> jugadores) {
        LinkedList<String> aux = new LinkedList<>();
        int j = 0;

        try {
            while (jugadores.Size() > 0) {
                aux.add(jugadores.get(m));
                jugadores.remove(m);
                if (jugadores.Size() > 0) jugadores.setStart(m-1);

            }
        } catch (NodeDontExist var) {
            System.out.println("out of boundss");
        }
        return aux;
    }


    public static void main(String[] args) {
      /*  DoublyCircledList hola = new DoublyCircledList();
        hola.add("Mateo");

        DoublyCircledList juan = hola;
        juan.add("Nacho");

        System.out.println(hola.Size());
        System.out.println(juan.Size());*/
/*
        DoublyCircledList<String> jugadores = new DoublyCircledList<>();
        jugadores.addOrder("Mate", "Juan", "Feli");
        jugadores.add("Laura");
        jugadores.add("Pelo");
        jugadores.add("Rama");
        jugadores.add("Andy");
        jugadores.add("Lula");
        jugadores.add("Nati");
        jugadores.add("Salva") ;

        try {
            System.out.println(jugadores.searchValue("Rama"));
            jugadores.swithcerooNode2("Rama", 1);
            System.out.println(jugadores.searchValue("Rama"));
            System.out.println(jugadores.get(6)+"holaa");
        }catch(NodeDontExist var){
            System.out.println(("Racffma"));
        }

        LinkedList<String> game = game(3, jugadores);

        for (int i = 0; i<game.size(); i++){
            System.out.println(game.get(i));
        }
*/
   /* Stack<String> stacky = new Stack<String>();
    stacky.push("Mate");
    stacky.push("Juli");
    stacky.push("Feli");
    stacky.push("lucio");
    stacky.push("nacho");
    System.out.println(stacky.top());
    stacky.pop();
    stacky.pop();
    System.out.println(stacky.top());
    System.out.println(stacky.isEmpty());
    stacky.makeEmpty();
    System.out.println(stacky.isEmpty());*/

       /* Queue<String>  cola = new Queue<String>();
        cola.enqueue("mate");
        cola.enqueue("salva");
        cola.enqueue("jp");
        cola.enqueue("pedro");
        cola.enqueue("lucia");
        cola.enqueue("rama");
        try {
            cola.dequeue();
            cola.dequeue();
            System.out.println(cola.getFirst());
            System.out.println(cola.isEmpty());
        }catch(EmptyQueueException var){
            System.out.println("que paso wei");
        }

*/

        BinarySearchTree<Integer,String> arbolito = new BinarySearchTree<Integer,String>();
        arbolito.insert(9,"Pepe");
        arbolito.insert(4, "Malena");
        System.out.println(arbolito.root.leftChild.data);
    }
}