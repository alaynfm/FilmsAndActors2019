package partidaCartas;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solitario {


   public void jugarPartirda(int numJugadores){
       Queue<Carta>[]jugador = new LinkedList[numJugadores];
       Bicola[] mesa = new Bicola[3];

       for (int i = 0; i< numJugadores;i++){
           jugador[i] = new LinkedList<Carta>();
       }

       for(int i=0; i<4;i++){
           mesa[i] = new Bicola();
       }


   }


}
