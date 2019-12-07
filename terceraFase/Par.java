package terceraFase;

public class Par {
    String nombreAP;
    double valor;

    public Par(String nom, double va){
        nombreAP = nom;
        valor=va;
    }

    public int compareTo(Par v){
        if(valor > v.valor) return 1;
        else if(valor < v.valor) return -1;
        else return 0;
    }
}
