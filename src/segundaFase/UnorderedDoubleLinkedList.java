package segundaFase;

import java.util.NoSuchElementException;

import primeraFase.Pelicula;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

	public void addToFront(T elem) {
		// añade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> now = new Node<T>(elem);
		if (first == null) {
			first = now;
			first.next = now;
			first.prev = now;
		} else {
			now.next = first;
			now.prev = first.prev;
			first.prev.next = now;
			first = now;
		}
		count++;

	}

	public void addToRear(T elem) {
		// añade un elemento al final
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> now = new Node<T>(elem);
		if (first == null) {
			first = now;
			now.next = now;
			now.prev = now;

		} else {
			now.next = first;
			now.prev = first.prev;
			first.prev.next = now;
			first.prev = now;
		}
		count++;

	}

	public void addAfter(T elem, T target) {
		// Añade elem detrás de otro elemento concreto, target, que ya se encuentra en
		// la lista
		// ¡COMPLETAR OPCIONAL!
		if (!isEmpty()) {
			boolean salir = false;
			boolean enc = false;
			Node<T> nuevo = new Node<T>(elem);
			Node<T> act = first;
			if(first == first.next || first.data.equals(target)) {
				nuevo.prev = act;
				nuevo.next = act.next;
				act.next.prev = nuevo;
				act.next= nuevo;
			}else {
				while(!salir & !enc) {
					act = act.next;
					if(act.data.equals(target)) {enc = true;
					}else if(first == act) {salir = true;}
				}
				nuevo.prev = act;
				nuevo.next = act.next;
				act.next.prev = nuevo;
				act.next = nuevo;				
			}			
		}
	}	
	public void imprimirDatos() {
		System.out.print(first.data);
		Node<T>act = first.next;
		while(act != first) {
			Pelicula p1 = (Pelicula) act.data;
			System.out.println(p1.getNombre());
			
		}
		System.out.println("");
	}
}
