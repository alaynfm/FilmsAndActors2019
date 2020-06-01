package primeraFase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Actor {
	private String nombre;
	private HashMap<String,Pelicula> listaPeliculas;

	public Actor(String pNombre) {
		nombre = pNombre;
		listaPeliculas = new HashMap<String,Pelicula>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public int compareTo(Actor actor) {
		return this.nombre.compareTo(actor.getNombre());
	}

	public void insertarPelicula(Pelicula pelip){
		if(!listaPeliculas.containsKey(pelip.getNombre())){
			listaPeliculas.put(pelip.getNombre(),pelip);
		}
	}

	public Pelicula[] obtenerPeliculasDelActor(){
		Collection<Pelicula> values = listaPeliculas.values();
		Pelicula[] targetArray = values.toArray(new Pelicula[values.size()]);
		return targetArray;

	}
	public ArrayList<String> obtenerNombrePeliculasDelActor(){
		Collection<String> values = listaPeliculas.keySet();
		ArrayList<String> targetArray = new ArrayList<String>(values);
		return targetArray;

	}

}
