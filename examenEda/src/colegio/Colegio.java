package colegio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Colegio {

    Queue<Queue<String>> q;

    public Colegio(){
        q = (Queue<Queue<String>>) new LinkedList();
        Queue<String> clase = (Queue<String>) new LinkedList<String>();
        clase.add("Alain Fernandez");
        clase.add("Marta Fernandez");
        Queue<String> clase1 = (Queue<String>) new LinkedList<String>();
        clase1.add("Alvaro Riano");
        clase1.add("Iratxe Gonzalez");
        q.add(clase);
        q.add(clase1);
    }
    public Queue<Queue<String>> devolverAlumnos(){
        Queue<Queue<String>> colaNueva = (Queue<Queue<String>>) new LinkedList();
        Iterator<Queue<String>> itr = q.iterator();
        while(itr.hasNext()){
            colaNueva.add(itr.next());

        }
        return colaNueva;
    }

    public void repartirRegalos(Queue<String> regalos) {
        Queue<Queue<String>> aux = q;
        if (!q.isEmpty()) {
            while (!regalos.isEmpty()) {
                String regalo = regalos.poll();
                aux.add(aux.peek());
                Queue<String> clase = aux.poll();
                for (int i = 0; i < clase.size(); i++) {
                    clase.add(clase.peek());
                    System.out.println("El alumno " + clase.poll() + "Del curso " + clase + "recibe el regalo " + regalo);

                }
            }
        }
    }

    public void test(){
        Queue<String> regalos = (Queue<String>) new LinkedList<String>();
        regalos.add("ot");
        regalos.add("sucionador");
        regalos.add("movil");
        regalos.add("mochila");
        repartirRegalos(regalos);

    }
    public static void main(String[] args) {
        new Colegio().test();
    }
}
