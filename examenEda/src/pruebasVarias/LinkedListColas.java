package pruebasVarias;


import cafeteria.NodeColas;

public class LinkedListColas<T> {

    private NodeColas<T> first;
    private NodeColas<T> last;
    private int numElementos;

    public LinkedListColas(){
        first = null;
        last = null;
        numElementos = 0;
    }

}
