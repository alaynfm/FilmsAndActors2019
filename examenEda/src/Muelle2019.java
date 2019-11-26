import java.util.Queue;
import java.util.Stack;

public class Muelle2019 {

    public class Peticion {
        String codigoDeContenedor;
        int muelle;
    }
    public class Barco {
        int tipo; // 0 (descarga), 1 (carga)
        String nombre;
        Queue<Peticion> peticiones;
    }
    public class Puerto {
        Stack<String>[] muelles;
        public void simularPuerto(Queue<Barco> barcos, int maxPeticiones, int numMuelles){
            // Pre: maxPeticiones es el número máximo de peticiones que se pueden atender en
            // el turno de un barco
            // Pre: numMuelles es el número de muelles del puerto (>=2). El muelle 0 es especial
            // Post: se ha simulado la actividad del puerto, atendiendo las peticiones de los barcos
            // crear los muelles

            muelles = new Stack[numMuelles];
            for(int i = 0 ; i<muelles.length;i++) muelles[i] = new Stack<String>();

            while(!barcos.isEmpty()) {
                Barco barco = barcos.peek();

                if (barco.tipo == 0) {//tipo descarga
                    for (int i = 0; i < maxPeticiones; i++) {
                        if (barco.peticiones.isEmpty()) break;
                        else {
                            Peticion pet = barco.peticiones.poll();
                            muelles[pet.muelle].push(pet.codigoDeContenedor);
                        }
                    }
                    if (!barco.peticiones.isEmpty()) barcos.add(barcos.poll());

                } else {//tipo carga
                    while(!barco.peticiones.isEmpty()){
                        if(!barco.peticiones.isEmpty()) {

                            Peticion pet = barco.peticiones.poll();
                            Stack<String> sacar = muelles[pet.muelle];
                            if(sacar.isEmpty()) {
                                while (sacar.peek() != pet.codigoDeContenedor)
                                    muelles[0].push(sacar.pop());

                                if (!sacar.isEmpty())sacar.pop();

                                while(!muelles[0].isEmpty()) sacar.push(muelles[0].pop());

                            }
                        }
                    }
                }
            }
        }
    }

}
