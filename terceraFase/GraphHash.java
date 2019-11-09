package terceraFase;

import primeraFase.Actor;
import primeraFase.ListaActor;
import primeraFase.ListaPelicula;
import primeraFase.Pelicula;

import java.util.*;

public class GraphHash {
    HashMap<String, ArrayList<String>> g;

    public GraphHash(){
        g = new HashMap<String, ArrayList<String>>();
    }

    public void crearGrafo() {
        // Post: crea el grafo desde la lista de actores
        // Los nodos son nombres de actores y títulos de películasç

        //Recorremos todas las peliculas
        try {
            Pelicula[] listaPeliculas = ListaPelicula.getListaPelicula().obtenerPeliculas(); //HashMap<String,Pelicula>

            for (int i = 0; i < listaPeliculas.length; i++) {

                String pelicula = "P" + listaPeliculas[i].getNombre();
                ArrayList<String> actoresMal = listaPeliculas[i].obtenerNombreActoresPeliculas();
                Iterator<String> itr = actoresMal.iterator();
                ArrayList<String> actores = new ArrayList<String>();

                while (itr.hasNext()) {
                    actores.add("A" + itr.next());
                }

                g.put(pelicula, actores);

            }

            //Recorremos todos los actores
            Actor[] listaActores = ListaActor.getMiLista().obtenerArrayActores();//HashMap<String,Actor>

            for (int a = 0; a < listaActores.length; a++) {
                String actor = "A" + listaActores[a].getNombre();
                ArrayList<String> peliculasMal = listaActores[a].obtenerNombrePeliculasDelActor();
                Iterator<String> ifm = peliculasMal.iterator();
                ArrayList<String> peliculas = new ArrayList<String>();
                while (ifm.hasNext()) {
                    peliculas.add("P" + ifm.next());
                }
                g.put(actor,peliculas);


            }
        }catch(Exception h ) {
            System.out.println("La pelicula no esta en la base de datos");
        }
    }
    public void print(){
        int i = 1;
        for (String s: g.keySet()){
            System.out.print("Element: " + i++ + " " + s + " --> ");
            for (String k: g.get(s)){
                System.out.print(k + " ### ");
            }
            System.out.println();
        }
    }
    public boolean estanConectados(String a1, String a2){

        boolean esta = false;
        String n1 = "A" +a1;
        String n2 = "A" + a2;

        if(g.containsKey(n1) & g.containsKey(n2)){
            Stack<String> porExaminar = new Stack<String>();
            HashSet<String> examinados = new HashSet<String>();
            porExaminar.push(n1);

            while(!porExaminar.isEmpty() & !esta) {
                String elementoAExamninar = porExaminar.pop();
                if (!examinados.contains(elementoAExamninar)) {
                    examinados.add(elementoAExamninar);
                    if (elementoAExamninar.equals(n2)) {
                        esta = true;
                    } else {
                        ArrayList<String> meterPila = g.get(elementoAExamninar);
                        Iterator<String> itr = meterPila.iterator();
                        while (itr.hasNext()) {
                            porExaminar.push(itr.next());
                        }
                    }
                }
            }

        }
        return esta;
    }
}
