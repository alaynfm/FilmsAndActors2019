package cafeteria;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TeamQueue {


	Queue<Queue<Integer>> q;
	HashMap<Integer, Integer> teams; //La clave es la persona y value el grupo al que pertenece.p
	


	
	
	public TeamQueue(){
		q = (Queue<Queue<Integer>>) new LinkedList();
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
		
		
		// Alternative solution:
	}
	

	
	public void enqueue(int x){
		Queue<Queue<Integer>> aux = (Queue<Queue<Integer>>) new LinkedList();
		boolean enc = false;

		while(!q.isEmpty()){
			Queue<Integer> grupo = q.poll();
			if(teams.get(grupo.peek()).equals(teams.get(x))){
				grupo.add(x);
				enc = true;
			}
			aux.add(grupo);
		}if(!enc){
			Queue<Integer> nuevo = (Queue<Integer>) new LinkedList();
			nuevo.add(x);
			aux.add(nuevo);
		}
		q = aux;
		
	}

	public void dequeue(){
		// Pre: cola no vacía
		if (!q.isEmpty()){
			int borrado = q.peek().remove();
			if (q.peek().isEmpty()) q.remove(); // si se ha sacado el último elemento de la primera cola, se quita
			System.out.println("Ha salido el " + borrado);
		}
	}	
	
	
	public void print(){
		// imprime el contenido de la cola, sin modificarla
		for (Queue<Integer> c: q){
			System.out.print("[");
			for (Integer x: c) System.out.print(x + " ");
			System.out.print("] ");
		}
		System.out.println();
	}

	
	private void test() {
		TeamQueue tq = new TeamQueue();
		tq.enqueue(2);
		tq.print();
		tq.enqueue(6);
		tq.print();
		tq.enqueue(8);
		tq.print();
		tq.enqueue(5);
		tq.print();
		tq.enqueue(4);
		tq.print();
		tq.enqueue(1);
		tq.print();
		tq.enqueue(3);
		tq.print();
		tq.dequeue();
		tq.print();
		tq.dequeue();
		tq.print();
		tq.dequeue();
		tq.print();
		tq.enqueue(11);
		tq.print();
	}
	public void anadirCola(int x){
		Queue<Queue<Integer>> aux = (Queue<Queue<Integer>>) new LinkedList();
		boolean enc = false;

		while(!q.isEmpty()){
			Queue<Integer> grupo = q.poll();
			if(teams.get(grupo.peek()).equals(teams.get(x))){
				grupo.add(x);
				enc = true;
			}
			aux.add(grupo);
		}if(!enc){
			Queue<Integer> nuevo = (Queue<Integer>) new LinkedList();
			nuevo.add(x);
			aux.add(nuevo);
		}
		q = aux;
	}

	public static void main(String[] args) {
		new TeamQueue().test();
	}
}
