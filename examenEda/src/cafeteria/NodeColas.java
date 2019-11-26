package cafeteria;

public class NodeColas<T> {

    NodeColas<T> sig;
    T data;

    public NodeColas(T pData){
        sig = null;
        data = pData;
    }
    public NodeColas(){
        sig = null;
        data = null;
    }
}
