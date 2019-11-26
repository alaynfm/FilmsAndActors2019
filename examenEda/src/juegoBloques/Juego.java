package juegoBloques;

import java.util.Stack;

public class Juego {

    public class Bloque{
        int puntos;
        int salto; // valor entre 0 y 6
        String direccion;

        public Bloque(int p, int s, String dir) {
            puntos = p;
            salto = s;
            direccion = dir;
        }
        public int getPuntos(){
            return puntos;
        }
        public int getSalto(){
            return salto;
        }
        public String getDireccion(){
            return direccion;
        }
    }
    Stack<Bloque>[] tablero; // array de pilas
    public static int NUMCOLUMNAS;

    public Juego(int numC) { // constructora
        tablero = (Stack<Bloque>[]) new Stack[numC];
        NUMCOLUMNAS = numC;
        for (int i = 0; i <= NUMCOLUMNAS - 1; i++) {
            tablero[i] = new Stack<Bloque>();
        }

        //Para crear aleatoriamente el tablero;
        for(int i = 0; i<NUMCOLUMNAS; i++){
            int numBloques = (int)(Math.random()*5)+1; //Como mucho hasta 5 bloques
            for(int a = 0; a<=numBloques;a++){
                int puntuacion = (int) (Math.random()*20)+1;  //Numero aleatorio hasta 20
                int salto = (int) (Math.random()*4)+1; //saltos de hasta 5 casillas
                int direc = (int) (Math.random()*2)+1;
                String d = null;
                if(direc == 1) d = "i";
                else d = "d";
                Bloque b = new Bloque(puntuacion,salto,d);
                tablero[i].push(b);
            }
        }
    }
    public int jugar() {
        // Pre: el juego ha sido inicializado (se han generado los
        // bloques de inicio)
        // Post: se ha jugado una partida, en la que la bola empieza
        // cayendo encima de la columna de en medio.
        // El resultado será el número de puntos obtenido al jugar con esa bola,
        // en caso de que el juego haya sido superado, y -1 en caso contrario
        int punt = 0;
        int posI = NUMCOLUMNAS % 2;

        boolean salir = false;
        while(!salir){
            if(!tablero[posI].isEmpty()) {
                Bloque b = tablero[posI].pop();
                punt = punt + b.puntos;

                if (b.direccion.equals("d")) { //Para que no salga por la derecha
                    posI = posI + b.salto;
                    if (posI > NUMCOLUMNAS) posI = posI -NUMCOLUMNAS;
                }
                else if (b.direccion.equals("i")) { //Para que no se salga a la izquierda
                    posI = posI - b.salto;
                    if (posI < 0) posI = posI + NUMCOLUMNAS;
                }
            }else salir = true;
        }
        return punt;
    }

    public void test(){
        System.out.println(jugar());
    }
    public static void main(String[] args) {
        new Juego(7).test();
    }
}
