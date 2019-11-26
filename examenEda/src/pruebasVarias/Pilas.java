package pruebasVarias;

import java.util.Iterator;
import java.util.Stack;

public class Pilas {
    Stack<String> pila = new Stack<String>();

    public void test(){
        pila.add("Alain");
        pila.add("Alvria");
        Iterator<String> itr = pila.iterator();
        Stack<String> p2 = new Stack<String>();
        while(itr.hasNext()) p2.add(itr.next());
        p2.pop();


    }
    public static void main(String[] args) {
        new Pilas().test();
    }
}
