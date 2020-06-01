package primeraFase;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class ListaPelicula<T> {
	private static ListaPelicula miLista = new ListaPelicula();
	private HashMap<String, Pelicula> listaPelicula;

	private ListaPelicula() {
		listaPelicula = new HashMap<String, Pelicula>();
	}

	public static ListaPelicula getListaPelicula() {
		return miLista;
	}

	public Pelicula getPelicula(String p) {
		if(listaPelicula.containsKey(p)){
			return listaPelicula.get(p);
		}else{
			return null;
		}
	}

	public void insertarPelicula(Pelicula pelip) {
		if (!listaPelicula.containsKey(pelip.getNombre())) {
			listaPelicula.put(pelip.getNombre(), pelip);
		}
	}

	public Actor[] obtenerActoresPelicula(Pelicula pelicula) {
		if (listaPelicula.containsKey(pelicula.getNombre())) {
			return listaPelicula.get(pelicula.getNombre()).obtenerActoresPeliculas();
		}else {return null;}
	}

	public void cargarDatos(String fichero) {

		try {
			Scanner input = new Scanner(new File(fichero));
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] v1 = line.split("\\s+--->\\s+");
				if(!ListaPelicula.getListaPelicula().estaPeli(v1[0])) {
					Pelicula pelicula = new Pelicula(v1[0]);
					ListaPelicula.getListaPelicula().insertarPelicula(pelicula);
				}
				Pelicula pelip = ListaPelicula.getListaPelicula().getPelicula(v1[0]);

				if(v1.length>=2) {
					String[] v2 = v1[1].split("\\s+&&&\\s+");
					for (int i = 0; i < v2.length; i++) {
						if(!ListaActor.getMiLista().estaActor(v2[i])) {
							Actor actor = new Actor(v2[i]);
							ListaActor.getMiLista().insertarActor(actor);
						}
						Actor a2 = ListaActor.getMiLista().getActor(v2[i]);
						pelip.insertarActor(a2);
						a2.insertarPelicula(pelip);
					}
				}
			}
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println();
	}

	public void guardarDatos() {

		FileWriter fichero = null;
		PrintWriter pw = null;

		try {
			fichero = new FileWriter("guardado.txt");
			pw = new PrintWriter(fichero);			
			
			Iterator hm = listaPelicula.entrySet().iterator();

			while (hm.hasNext()) {
				Map.Entry mapElement = (Map.Entry) hm.next();
				pw.print(mapElement.getKey() + " ---> ");
				Iterator hs = this.devolverActorPelis((Pelicula) mapElement.getValue()).entrySet().iterator();
				while (hs.hasNext()) {
					Map.Entry entry1 = (Map.Entry) hs.next();
					pw.print(entry1.getKey() + " && ");
				}
				pw.println("");
			}
			ListaActor.getMiLista().guardarListaActoresOrdenada();
		}
		catch (Exception e) {
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

	private HashMap<String,Actor> devolverActorPelis(Pelicula peli) {
		return listaPelicula.get(peli.getNombre()).getActores();

	}

	public void incrementarDinero(String pelicula, double dinero) {
		if(listaPelicula.containsKey(pelicula)) {
			listaPelicula.get(pelicula).aumentarDinero(dinero);
		}
	}
	public boolean estaPeli(String peli) {
		return listaPelicula.containsKey(peli);
	}

	public Pelicula[] obtenerPeliculas(){
		Collection<Pelicula> values = listaPelicula.values();
		Pelicula[] targetArray = values.toArray(new Pelicula[values.size()]);
		return targetArray;
	}

}