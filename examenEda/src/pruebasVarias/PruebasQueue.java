package pruebasVarias;

import java.util.LinkedList;
import java.util.Queue;

public class PruebasQueue {

    Queue<Queue<Integer>> aux = (Queue<Queue<Integer>>) new LinkedList();
    public void anadirElemento(int i){

        Queue<Queue<Integer>> aux = (Queue<Queue<Integer>>) new LinkedList();
        for(Queue<Integer>v: aux) {
            Queue<Integer> r = aux.peek();
        }
        if(aux.isEmpty()){
            Queue<Integer> lista = new LinkedList<Integer>();
            lista.add(i);
            aux.add(lista);
        }else{
            if(i == 2) {
                Queue<Integer> lista = aux.peek();
                lista.add(i);
            }else{

            }
        }

    }
    public void test(){
        this.anadirElemento(1);
        this.anadirElemento(2);
        this.anadirElemento(3);
    }

    public static void main(String[] args) {
        new PruebasQueue().test();
    }
}
