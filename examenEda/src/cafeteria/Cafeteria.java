package cafeteria;

import java.util.*;

public class Cafeteria {

    NodeColas<LinkedList<Integer>> first;
    HashMap<Integer, Integer> teams; //La clave es la persona y value el grupo al que pertenece.p

    public Cafeteria(){
        first = null;
        teams = new HashMap<Integer, Integer>();
        // Grupo A: 1, 5, 7
        // Grupo B: 2, 4, 8, 10
        // Grupo C: 3, 6, 11
        teams.put(1, 1);
        teams.put(5, 1);
        teams.put(7, 1);
        teams.put(2, 2);
        teams.put(4, 2);
        teams.put(8, 2);
        teams.put(10, 2);
        teams.put(3, 3);
        teams.put(6, 3);
        teams.put(11, 3);
    }
    public void enqueue(int x) {

        if (first != null) {
            NodeColas<LinkedList<Integer>> node = first;
            NodeColas<LinkedList<Integer>> ant = null;
            boolean salir = false;
            while (node != null & !salir) {
                ant = node;
                node = node.sig;
                LinkedList<Integer> act = ant.data;
                if (!act.isEmpty()) {
                    if (teams.get(act.getFirst()).equals(teams.get(x))) {
                        salir = true;
                    }
                }
            }
            if (salir) {//hemos encontrado la cola en la que hay que insertarlo
                ant.data.add(x);
            } else { // no ha encontrado la cola, se crea una nueva y se inserta
                LinkedList<Integer> nueva = new LinkedList<Integer>();
                nueva.add(x);
                NodeColas<LinkedList<Integer>> nuvoNodo = new NodeColas<LinkedList<Integer>>(nueva);
                nuvoNodo.sig = ant.sig;
                ant.sig = nuvoNodo;
            }

        }else{
            LinkedList<Integer> nueva = new LinkedList<Integer>();
            nueva.add(x);
            NodeColas<LinkedList<Integer>> nuvoNodo = new NodeColas<LinkedList<Integer>>(nueva);
            first = nuvoNodo;
        }

    }

    public void deQueue(){
        if(first != null){
            LinkedList<Integer> nuevo= first.data;
            nuevo.poll();
            if(nuevo.isEmpty()) first = first.sig;
        }

    }

    public void print(){
        // imprime el contenido de la cola, sin modificarla
        NodeColas<LinkedList<Integer>> act = first;
        while(act != null){
            LinkedList<Integer> a = act.data;
            System.out.print("[ ");
            for (Integer x: a) System.out.print(x + " ");
            System.out.print("]");
            System.out.print(" ");
            act = act.sig;
        }
    }




    private void test() {
        Cafeteria tq = new Cafeteria();
        tq.enqueue(2);
        tq.enqueue(6);
        tq.enqueue(8);
        tq.enqueue(5);
        tq.enqueue(4);
        tq.enqueue(1);
        tq.enqueue(3);
        tq.deQueue();
        //tq.print();
        tq.deQueue();
        //tq.print();
        tq.deQueue();
        //tq.print();
        tq.deQueue();
        tq.deQueue();
        tq.deQueue();
        tq.deQueue();
        tq.enqueue(11);
        tq.deQueue();
        tq.print();
    }

    public static void main(String[] args) {
        new Cafeteria().test();
    }
}


