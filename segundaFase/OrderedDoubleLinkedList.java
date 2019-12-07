package segundaFase;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {

	public void add(T elem) {
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		boolean salir = false;
		boolean enc = false;
		boolean iguales = false;
		Comparable<T> dato = (Comparable<T>) elem;
		Node<T> nuevo = new Node<T>(elem);
		
		if(!isEmpty()) {
			if(dato.compareTo(first.data ) < 0) { //insertar al principio
				nuevo.next = first;
				nuevo.prev = first.prev;
				first.prev.next = nuevo;
				first.prev = nuevo;
				first = nuevo;
				count++;
			}else {
				Node<T>act = first;
				Node<T>ant = first;
				while(!salir & !enc) {
					ant = act;
					act = act.next;
					if(dato.compareTo(act.data) < 0) {enc = true;}
					else if(dato.compareTo(act.data) ==0){enc= true;iguales= true;}	
					else if (act == first){salir = true;}	

				}
				if(!iguales) {
					nuevo.prev = ant;
					ant.next = nuevo;
					nuevo.next = act;
					act.prev = nuevo;	
					count++;
			
				}
			}
		}
		else {//si la lista esta vacia
			nuevo.next = nuevo;
			nuevo.prev = nuevo;
			first = nuevo;
			count++;
		}
	}

	public void merge(DoubleLinkedList<T> lista) {
		Node<T>act = lista.first;
		for(int i = 0; i <lista.count; i++) {
			add(act.data);
			act = act.next;
		}
	}

}
