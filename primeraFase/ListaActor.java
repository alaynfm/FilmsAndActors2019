package primeraFase;

import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.Collection;
import java.util.HashMap;


public class ListaActor <T>{

	private HashMap<String, Actor> listaActores;
	private static ListaActor miLista = new ListaActor();

	private ListaActor() {
		listaActores = new HashMap<String, Actor>();
	}

	public static ListaActor getMiLista() {
		return miLista;
	}

	public void insertarActor(Actor nActor) {
		if (!listaActores.containsKey(nActor.getNombre())) {
			listaActores.put(nActor.getNombre(), nActor);
		}
	}

	public void borrarActor(Actor actor) {
		if (listaActores.containsKey(actor.getNombre())) {
			Pelicula[] pelis = listaActores.get(actor.getNombre()).obtenerPeliculasDelActor();
			for(int i= 0 ; i<pelis.length; i++){
				pelis[i].borrarActor(actor.getNombre());
			}
			listaActores.remove(actor.getNombre());

		}
	}

	public boolean estaActor(String actor) {
		return listaActores.containsKey(actor);
	}

	/*
	 * Obteber lista de Actores ordenada:
	 * 
	 * Vamos a ordenarlo mediante el metodo quickSort o(n log n) Despues de ordenar
	 * los actores, para no ocupar más espacio y poder mostrar todos los actores
	 * vamos a escribirlos en el fichero actor.
	 * 
	 * Vamos a utilizar el HashMap<String, Actor> como dato principal. Copiamos los
	 * valores del Hashmap en Actor[] y lo ordenamos mediante el quickSort Copiamos
	 * el Actor[] en el fichero actor
	 * 
	 */

	private Actor[] obtenerArrayActores() {

		Collection<Actor> values = listaActores.values();
		Actor[] targetArray = values.toArray(new Actor[values.size()]);
		Ordenar ordenar = new Ordenar();
		ordenar.quickSort(targetArray, 0, targetArray.length - 1);
		return targetArray;
	}

	public void guardarListaActoresOrdenada() {

		FileWriter fichero = null;
		PrintWriter pw = null;

		try {
			fichero = new FileWriter("actor.txt");
			pw = new PrintWriter(fichero);
			Actor[] lista = this.obtenerArrayActores();

			for (int i = 0; i < lista.length; i++) {
				pw.println(lista[i].getNombre());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	public Pelicula[] obtenerPeliculasDelActor(Actor actor){
		if(listaActores.containsKey(actor.getNombre())){
			return listaActores.get(actor.getNombre()).obtenerPeliculasDelActor();
		}else{
			return null;
		}
	}
	public Actor getActor(String actor){
		if(listaActores.containsKey(actor)){
			return listaActores.get(actor);
		}else return null;
	}
	public int getNumActores() {
		return listaActores.size();
	}

}