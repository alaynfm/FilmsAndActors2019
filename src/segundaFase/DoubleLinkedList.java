package segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first; // apuntador al primero
	protected String descr; // descripción
	protected int count;

	// Constructor
	public DoubleLinkedList() {
		first = null;
		descr = "";
		count = 0;
	}

	public void setDescr(String nom) {
		descr = nom;
	}

	public String getDescr() {
		return descr;
	}

	public T removeFirst() {
		// Elimina el primer elemento de la lista
		// Precondición: la lista tiene al menos un elemento
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T data = null;
		if (!isEmpty()) {
			if (first == first.next) {
				data = first.data;
				first = null;
			} else {
				Node<T> act = first;
				data = act.data;
				first = act.next;
				first.prev = act.prev;
			}
			count--;
		} else {
			throw new NoSuchElementException();// La lista es vacia
		}

		return data;

	}

	public T removeLast() {
		// Elimina el último elemento de la lista
		// Precondición: la lista tiene al menos un elemento
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T data = null;
		if (!isEmpty()) {
			if (first == first.next) {
				first = null;
				data = first.data;
			} else {
				Node<T> act = first.prev;
				first.prev = act.prev;
				act.prev.next = first;
				data = act.data;
			}
			count--;
		} else {
			throw new NoSuchElementException();// La lista es vacia
		}
		return data;
	}

	public T remove(T elem) {
		// Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T data = null;
		boolean salir = false;

		if (!isEmpty()) {
			Node<T> act = first;
			if (act.next == first) { // Solo hay un elemento en la lista
				if (act.data.equals(elem)) {
					first = null;
					data = act.data;
					count--;
				} else {
					throw new NoSuchElementException();
				} // El elemento no esta en la lista
			} else {
				Node<T> ant = first;
				while (!act.data.equals(elem) & !salir) {
					ant = act;
					act = act.next;
					if (act == first) {
						salir = true;
					}
				}
				if (!salir) { // Quiere decir que hemos encontrado el elemento, no hemos recorrido hasta el
								// final
					if (ant == act) { // Quiere decir que esta en la primera posicion
						data = act.data;// guardamos el dato a eliminar
						act = act.next; // Avanzamos una posicion
						act.prev = first.prev; // El anterior apunta al ultimo
						first.prev.next = act;
						first = act;
					} else {// en caso de que este en el medio o en el final
						data = act.data;
						ant.next = act.next;
						act = act.next;
						act.prev = ant;
					}
					count--;
				} else {
					throw new NoSuchElementException();
				} // El elemento no esta en la lista

			}
		} else {
			throw new NoSuchElementException();
		} // El elemento no esta en la lista
		return data;
	}

	public T first() {
		// Da acceso al primer elemento de la lista
		if (isEmpty())
			return null;
		else
			return first.data;
	}

	public T last() {
		// Da acceso al último elemento de la lista
		if (isEmpty())
			return null;
		else
			return first.prev.data;
	}

	public boolean contains(T elem) {
		// Determina si la lista contiene un elemento concreto
		boolean salir = false;
		Node<T> act = first;
		while (!salir & !act.data.equals(elem)) {
			act = act.next;
			if (act.data.equals(elem)) {
				salir = true;
			}
		}
		return salir == false;// Si salimos antes de convertir en true significa que lo hemos encontrado
	}

	public T find(T elem) {
		// Determina si la lista contiene un elemento concreto, y develve su referencia,
		// null en caso de que no esté
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T data = null;
		boolean salir = false;
		Node<T> act = first;
		if (!isEmpty()) {
			while (!salir & !act.data.equals(elem)) {
				act = act.next;
				if (act == first) {
					salir = true;
				}
			}
			if (!salir) {
				data = act.data;
			}
		}
		return data;// Devuelve null si no lo hemos encontrado
	}

	public boolean isEmpty()
	// Determina si la lista está vacía
	{
		return first == null;
	};

	public int size()
	// Determina el número de elementos de la lista
	{
		return count;
	};

	/** Return an iterator to the stack that iterates through the items . */
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator implements Iterator<T> {

		Node<T> itr = first;
		boolean salir = false;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (first == itr & !salir) {
				salir = true;
				return true;
			} else if (first == itr & salir) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub

			T data = itr.data;
			itr = itr.next;
			return data;

		}

		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

	} // private class

	public void visualizarNodos() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		String result = new String();
		Iterator<T> it = iterator();
		if (!isEmpty()) {
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem + "] ";
			}
		}
		return "SimpleLinkedList " + result + "/n";
	}

}
