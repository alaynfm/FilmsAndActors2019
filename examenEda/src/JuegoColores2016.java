import java.util.Queue;
import java.util.Stack;

public class JuegoColores2016 {

        Queue<Integer>[] jugadores;
        // Los colores de las fichas se representan por enteros ,donde las fichas
        // negras vienen dadas por el 0, y el resto de jugadores tendrán el color
        // correspondiente a la posición del jugador (es decir, el jugador 1 tendrá
        // fichas de valor 1, ...)
        Stack<Integer> mesa;
        public int juego(int n, int nJugadores) {
            jugadores = new Queue[nJugadores];
            int d1 = -1;
            int d2 = -1;
            boolean salir = false;

            while(!salir){
                d1 = (int)(Math.random()*5);
                d2 = (int)(Math.random()*5);
                if(d1 == 6) salir = true;
                else{
                    if(!mesa.isEmpty()) {
                        if (d1 % 2 == 0) mesa.push(jugadores[d2].poll());
                        else jugadores[d2].add(mesa.pop());
                    }
                }
            }//hemos sacado un 6
            int puntuacion = 0;
            int jugador= 0;
            for(int i = 0; i<jugadores.length;i++){
                int puntJ = 0;
                while(!jugadores[i].isEmpty()){
                    if (jugadores[i].poll() == 0) puntuacion++;
                }
                if(puntJ > puntuacion){
                    jugador = i;
                    puntuacion = puntJ;
                }
            }
            return jugador;
        }
        public class Tirada {
            int dado1;
            int dado2;
        }

    }
