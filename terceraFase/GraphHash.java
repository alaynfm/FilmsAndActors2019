package terceraFase;

import primeraFase.Actor;
import primeraFase.ListaActor;
import primeraFase.ListaPelicula;
import primeraFase.Pelicula;
import sort.Ordenar;

import java.util.*;
import java.util.function.DoublePredicate;

public class GraphHash<T>{

    HashMap<String, ArrayList<String>> g;
    /*Para el entrgable 4 creamos un HashMap<String,Double>
        String : nombre de la pelicula o el actor
        Double : valor de la pelicula/acot. Valor inicial 2.5
     */
    HashMap<String,Double> pagerank;
    Double valor = 0.0;


    public GraphHash(){
        g = new HashMap<String, ArrayList<String>>();
        pagerank = new HashMap<String,Double>();
    }

    public void crearGrafo() {
        //pre: No hay peliculas sin actores ni actores sin peliculas.
        // Post: crea el grafo desde la lista de actores
        // Los nodos son nombres de actores y títulos de películasç
        //Recorremos todas las peliculas
        try {
            Pelicula[] listaPeliculas = ListaPelicula.getListaPelicula().obtenerPeliculas(); //HashMap<String,Pelicula>
            Actor[] listaActores = ListaActor.getMiLista().obtenerArrayActores();//HashMap<String,Actor>
            valor = (listaActores.length + listaPeliculas.length) * 1.0;

            for (int i = 0; i < listaPeliculas.length; i++) {

                String pelicula = "P" + listaPeliculas[i].getNombre();

                ArrayList<String> actoresMal = listaPeliculas[i].obtenerNombreActoresPeliculas();
                Iterator<String> itr = actoresMal.iterator();
                ArrayList<String> actores = new ArrayList<String>();
                pagerank.put(pelicula, 1/valor);

                while (itr.hasNext()) {
                    actores.add("A" + itr.next());
                }

                g.put(pelicula, actores);

            }

            //Recorremos todos los actores


            for (int a = 0; a < listaActores.length; a++) {
                String actor = "A" + listaActores[a].getNombre();

                ArrayList<String> peliculasMal = listaActores[a].obtenerNombrePeliculasDelActor();
                Iterator<String> ifm = peliculasMal.iterator();
                ArrayList<String> peliculas = new ArrayList<String>();
                pagerank.put(actor,1/valor);
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
    public boolean recorridoEnProfundidad(String a1, String a2){

        ArrayList<String> camino = new ArrayList<String>();
        boolean esta = false;
        String n1 = "A" +a1;
        String n2 = "A" + a2;

        if(g.containsKey(n1) & g.containsKey(n2)){

            Stack<String> porExaminar = new Stack<String>();
            HashSet<String> examinados = new HashSet<String>();
            porExaminar.push(n1);
            HashMap<String,String> recorrido = new HashMap<String, String>();//La clave es el destino

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
                            String element = itr.next();
                            if(!examinados.contains(element)) {
                                porExaminar.push(element);
                                recorrido.put(element,elementoAExamninar);
                            }
                        }
                    }
                }
            }
        }
        return esta;
    }
    public ArrayList<String> recorridoEnAnchura(String a1,String a2){

        ArrayList<String> camino = new ArrayList<String>();
        boolean esta = false;
        String n1 = "A" +a1;
        String n2 = "A" + a2;

        if(g.containsKey(n1) & g.containsKey(n2)){

            Queue<String> porExaminar = new LinkedList<String>();
            HashSet<String> examinados = new HashSet<String>();
            porExaminar.add(n1);
            HashMap<String,String> recorrido = new HashMap<String, String>();//La clave es el destino

            while(!porExaminar.isEmpty() & !esta) {
                String elementoAExamninar = porExaminar.poll();

                if (!examinados.contains(elementoAExamninar)) {

                    examinados.add(elementoAExamninar);

                    if (elementoAExamninar.equals(n2)) {
                        esta = true;

                    } else {
                        ArrayList<String> meterPila = g.get(elementoAExamninar);
                        Iterator<String> itr = meterPila.iterator();
                        while (itr.hasNext()) {
                            String element = itr.next();
                            if(!examinados.contains(element)) {
                                porExaminar.add(element);
                                recorrido.put(element,elementoAExamninar);
                            }
                        }
                    }
                }
            }

            if(esta) {
                boolean salir2 = false;
                camino.add(n2);
                String elementoR = n2;

                while (!salir2) {
                    if (n1.equals(elementoR)) {
                        salir2 = true;
                    } else {
                        elementoR = recorrido.get(elementoR);
                        camino.add(elementoR);
                    }
                }
            }

        }


        return camino;
    }

    public HashMap<String,Double> pageRannk(){

        int iteraciones = 0;
        boolean salir = false;
        HashMap<String,Double> iteracion = new HashMap<String,Double>();


        while(!salir) {

            iteraciones++;
            double valorF = 0.0;

            //Iniciamos la Iteracion
            for (Map.Entry<String, Double> entry : pagerank.entrySet()) { //entry.getKey & //entry.getValue

                ArrayList<String> data = g.get(entry.getKey());
                double value = 0.0;
                for (String element : data) {
                    value = value + (pagerank.get(element) /g.get(element).size());
                }
                Double valorN = (((1-0.85)/valor)+0.85) * value;
                iteracion.put(entry.getKey(),valorN);
                valorF = valorF + Math.abs(pagerank.get(entry.getKey()) - iteracion.get(entry.getKey()));

            }

            if( valorF <=0.0001) salir = true;

            pagerank.clear();
            pagerank = (HashMap<String, Double>) iteracion.clone();
            iteracion.clear();
            System.out.println(iteraciones + "  " +  valorF);
        }

        return pagerank;
    }
    public boolean isEmpty(){
        return g.isEmpty();
    }

    public Par[] buscar (String nombre){
        pageRannk();
        ArrayList<String> lista = g.get(nombre);
        Par[] listaP = new Par[lista.size()];
        for(int i = 0; i<lista.size();i++){
            Par par = new Par(lista.get(i),pagerank.get(lista.get(i)));
            listaP[i] = par;
        }
        Ordenar ordenar = new Ordenar<>();
        ordenar.quickSortG(listaP, 0, listaP.length-1);
        return listaP;
    }
}