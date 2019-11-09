package primeraFase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Pelicula {
	private String nombre;
	private double recaudado;
	private HashMap<String,Actor> actores;
	
	
	public Pelicula(String pNombre) {
		nombre = pNombre;
		recaudado = 0;
		actores = new HashMap<String, Actor>();
	}

	public HashMap<String,Actor> getActores(){
		return actores;
	}
	public void aumentarDinero(double pDinero) {
		recaudado = recaudado + pDinero;
	}
	public String getNombre() {return this.nombre;}
	
	public void insertarActor(Actor actor) {
		if(!actores.containsKey(actor.getNombre())) {
			actores.put(actor.getNombre(), actor);
		}
	}
	public Actor[] obtenerActoresPeliculas() {
		Collection<Actor> values = actores.values();
		Actor[] targetArray = values.toArray(new Actor[values.size()]);
		return targetArray;
	}
	public ArrayList<String> obtenerNombreActoresPeliculas(){
		Collection<String> values = actores.keySet();
		ArrayList<String> targetArray = new ArrayList<String>(values);
		return targetArray;

	}
	public boolean tieneActor(Actor actor) {
		return actores.containsKey(actor.getNombre());
	}

	public void borrarActor(String actor){
		if(actores.containsKey(actor)){
			actores.remove(actor);
		}
	}
	public void imprimir() {
		System.out.println("");
		System.out.println("     " + this.nombre);
		System.out.println("     " + "Recaudado -> " + this.recaudado);
	}
}
