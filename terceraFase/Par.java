package terceraFase;

public class Par {
    String nombreAP;
    double valor;

    public Par(String nom, double va){
        nombreAP = nom;
        valor=va;
    }
    public String nombre() {return nombreAP;}
    public double valor(){return valor;}
    public int compareTo(Par v){
        if(valor > v.valor) return 1;
        else if(valor < v.valor) return -1;
        else return 0;
    }
}
