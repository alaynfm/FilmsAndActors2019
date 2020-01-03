package segundaFase;

import java.util.Iterator;

public class PruebaDoubleLinkedList {

	public static void visualizarNodos(UnorderedDoubleLinkedList<Integer> l) {
		Iterator<Integer> it = l.iterator();
		System.out.println();
		if (!l.isEmpty()) {
			while (it.hasNext()) {
				Integer num = it.next();
				System.out.println(num);
			}
		}
	}

	public static void main(String[] args) {

		UnorderedDoubleLinkedList<Integer> l = new UnorderedDoubleLinkedList<Integer>();
		// Anadir al principio
		System.out.println("Casos de prueba anadir al Final");
		l.addToRear(1);
		l.visualizarNodos(); // solo tiene que haber un elemetno
		l.addToRear(3);
		l.visualizarNodos();// solo tienne que haber dos elementos
		l.addToRear(4);
		l.visualizarNodos();// solo tiene que haber tres elementos

		System.out.println("Casos de prueba Eliminar elementos");
		System.out.println("Tiene que eliminar el 1 y elimina el: " + l.remove(1));
		System.out.println("Tiene que eliminar el 3 y elimina el: " + l.remove(3));
		System.out.println("Tiene que eliminar el 4 y elimina el: " + l.remove(4));
		l.visualizarNodos();// no tiene que haber elementos en la lista

		System.out.println("Casos de prueba anadir al Principio");
		l.addToFront(8);
		l.visualizarNodos(); // solo tiene que haber un elemetno
		l.addToFront(7);
		l.visualizarNodos(); // solo tiene que haber dos elemetnos
		l.addToFront(6);
		l.visualizarNodos(); // solo tiene que haber tres elemetnos
		System.out.println(l.remove(8));
		System.out.println(l.remove(7));
		System.out.println(l.remove(6));
		l.visualizarNodos();

		System.out.print(" Lista ...............");
		l.visualizarNodos();
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());

		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9)); //Cuando no hay nada devería de volver null;
		l.addToRear(new Integer(1));
		System.out.println("1? " + l.find(1)); //Cuadno hay un elemento y esta en la lista;
		System.out.println("0? " + l.find(0)); //Cuadno hay un elemento y no esta en la lista;
		l.addToRear(new Integer(2));
		l.addToRear(new Integer(3));
		System.out.println("1? " + l.find(1));//Cuando hay mas de un elemento y esta al principio;
		System.out.println("2? " + l.find(2));//Cuando hay mas de un elemento y esta en el medio;
		System.out.println("3? " + l.find(3));//Cuando hay mas de un elemento y esta al final;
		System.out.println("null? " + l.find(9));//Cuando hay mas de un elemento y no esta;

		System.out.println("Add after");
		l.visualizarNodos();
		l.addAfter(4, 3);
		l.visualizarNodos();
		l.addAfter(0, 1);
		l.visualizarNodos();
		l.addAfter(-1, 2);
		l.visualizarNodos();
		UnorderedDoubleLinkedList<Integer> l1 = new UnorderedDoubleLinkedList<Integer>();
		l1.addToFront(1);
		l1.addAfter(2, 1);
		l1.visualizarNodos();
		l.addToRear(4);
		l.addAfter(5, 4);
		l.visualizarNodos();

		

		UnorderedDoubleLinkedList<Persona> l13 = new UnorderedDoubleLinkedList<Persona>();
		Persona p1 = new Persona("alain","dni");
		l13.addToRear(p1);
		l13.visualizarNodos();

	}
}
