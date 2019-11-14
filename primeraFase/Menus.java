package primeraFase;

import terceraFase.GraphHash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menus<T> {

	private static Menus miMenu = new Menus();
	private Menus() {
	}
	public static Menus getMenu() {
		return miMenu;
	}
	public void ejecutarMenu() {
		
		String datos;
		boolean grafoCreado = false;
		GraphHash g = new GraphHash();
		int opcion;
		boolean salir = false;
		g.inicializarArray();

		Scanner sc = new Scanner(System.in);
		StopWatch timer1 = new StopWatch();
		ListaPelicula.getListaPelicula().cargarDatos("FilmsActors20162017.txt");
		System.out.println("Ha tardado " + timer1.elapsedTime() + " segundos en cargar los ficheros");

		while (!salir) {

			try {
				System.out.println("-------------------------------------");
				System.out.println("| 1. Buscar Actor                   |");
				System.out.println("| 2. Buscar Peliculas de un Actor   |");
				System.out.println("| 3. Insertar Actor                 |");
				System.out.println("| 4. Obtener Lista Actores ordenada |");
				System.out.println("| 5. Borrar un actor                |");
				System.out.println("| 6. Buscar Pelicula                |");
				System.out.println("| 7. Incrementar dinero Pelicula    |");
				System.out.println("| 8. Obtener Actores Pelicula       |");
				System.out.println("| 9. Crear grafo                    |");
				System.out.println("| 10. Recorrido por Anchura         |");
				System.out.println("| 11. Recorrido en Profundidad      |");
				System.out.println("| 12. Mostrar Grafo                 |");
				System.out.println("| 13. Guardar datos y salir         |");
				System.out.println("-------------------------------------");

				System.out.println("Escribe una opcion en forma de numero");
				opcion = Integer.parseInt(sc.nextLine());
				switch (opcion) {
				case 1:
					System.out.println("---------------------------------------------------------");
					System.out.println("| BUSCAR UN ACTOR                                       |");
					System.out.println("|                                                       |");
					System.out.println("|Introduzca el nombre de un actor                       |");
					System.out.print("---------------------------------------------------------   ");

					datos = sc.nextLine();
					StopWatch timer2 = new StopWatch();
					if (!ListaActor.getMiLista().estaActor(datos)) {
						System.out.println("El actor no se encuentra en la base de datos           ");
					} else {
						System.out.println("El actor " + datos + " se encuentra en la base de datos");
					}
					System.out.println("Ha tardado en encontar el actor: " + timer2.elapsedTime() + " segundos");
					System.out.println(" ");
					System.out.println("Pulsa intro para continuar");
					sc.nextLine();
					break;
				case 2:
					System.out.println("----------------------------------------------------------");
					System.out.println("| BUSCAR PELICULAS DE UN ACTOR                           |");
					System.out.println("|                                                        |");
					System.out.println("| Si el actor no se encuentra en la bd no devolvera nada |");
					System.out.println("| Introduzca el nombre del Actor                         |");
					System.out.print("----------------------------------------------------------   ");
					datos = sc.nextLine();
					StopWatch timer3 = new StopWatch();
					if (ListaActor.getMiLista().estaActor(datos)) {
						Pelicula[] peliculas = ListaActor.getMiLista().obtenerPeliculasDelActor(new Actor(datos));
						System.out.print(datos + " Tiene estas peliculas: ");
						for(int i = 0; i< peliculas.length; i++){
							System.out.print(" " + peliculas[i].getNombre() + " && ");
						}
						System.out.println();
						System.out.println(
								"Ha tardado en encontrar las peliculas del actor " + timer3.elapsedTime() + " segundos ");
						System.out.println(" ");
						System.out.println("Pulsa intro para continuar");
						sc.nextLine();
					}
					break;
				case 3:
					System.out.println("---------------------------------------------------------");
					System.out.println("| INSERTAR UN ACTOR                                      ");
					System.out.println("|                                                       |");
					System.out.println("|Si el Actor ya se encuentra no lo insertara de nuevo   |");
					System.out.println("|Escribe el nombre de un Actor a insertar :             |");
					System.out.print("---------------------------------------------------------   ");

					grafoCreado = false;
					datos = sc.nextLine();
					StopWatch timer4 = new StopWatch();
					ListaActor.getMiLista().insertarActor(new Actor(datos));
					System.out.println("Para comprobar que el Actor se ha insertado correctamente ejecutar buscar Actor");
					System.out.println("Ha tardado en insertar el actor: " + timer4.elapsedTime());
					System.out.println(" ");
					System.out.println("Pulsa intro para continuar");

					sc.nextLine();
					break;
				case 4:
					System.out.println("---------------------------------------------------------");
					System.out.println("| Obtener lista de Actores ordenada                      ");
					System.out.println("|                                                       |");
					System.out.println("|Obtendremos una lista de actores ordenada              |");
					System.out.println("|La lista la escribiremos en el fichero actores         |");
					System.out.println("---------------------------------------------------------");
					StopWatch timer5 = new StopWatch();
					ListaActor.getMiLista().guardarListaActoresOrdenada();
					System.out.println("Ha tardado " + timer5.elapsedTime() + " segundos");
					System.out.println(" ");
					System.out.println("Pulsa intro para continuar");
					sc.nextLine();
					break;
				case 5:
					System.out.println("---------------------------------------------------------");
					System.out.println("| Borrar actor de una Pelicula                           |");
					System.out.println("|                                                       |");
					System.out.println("|Borraremos un actor en la lista                        |");
					System.out.println("|Si no esta, no haremos nada                            |");
					System.out.print("---------------------------------------------------------   ");
					datos = sc.nextLine();
					StopWatch timer6 = new StopWatch();
					ListaActor.getMiLista().borrarActor(new Actor(datos));;
					System.out.println("Para comprobar que el actor no se encuentra ejecutar buscar Actor");
					System.out.println("Ha tardado " + timer6.elapsedTime() + " segundos");
					System.out.println("Pulsa intro para continuar");
					sc.nextLine();
					break;
				case 6:
					System.out.println("-----------------------------------------------------------------");
					System.out.println("| BUSCAR PELICULA                                               |");
					System.out.println("|                                                               |");
					System.out.println("| Si la pelicula no se encuentra en la bd, no se devolvera nada |");
					System.out.println("| Introduzca el nombre de la Pelicula                           |");
					System.out.print("-------------------------------------------------------------------   ");
					datos = sc.nextLine();
					StopWatch timer7 = new StopWatch();
					try {
						Pelicula peli = ListaPelicula.getListaPelicula().getPelicula(datos);
						peli.imprimir();
						}
						catch(Exception a){
							System.out.println("La pelicula no esta en la base de datos");	
						}
					
					System.out.println("");
					System.out.println("Ha tardado " + timer7.elapsedTime() + " segundos");
					System.out.println("Pulsa intro para continuar");
					sc.nextLine();
					break;
				case 7:
					System.out.println("---------------------------------------------------------");
					System.out.println("| Incrementar dinero Pelicula                           |");
					System.out.println("|                                                       |");
					System.out.println("|¿En qué película lo quieres insertar?                  |");
					System.out.print("---------------------------------------------------------   ");
					datos = sc.nextLine();
					ListaPelicula.getListaPelicula().getPelicula(datos).imprimir();
					System.out.println("");
					System.out.println("---------------------------------------------------------");
					System.out.println("| Incrementar dinero Pelicula                           |");
					System.out.println("|                                                       |");
					System.out.println("|¿Cuánto dinero quieres insertar?                       |");
					System.out.print("---------------------------------------------------------   ");
					Double datos1 = Double.parseDouble(sc.nextLine());
					StopWatch timer8 = new StopWatch();
					try {
						ListaPelicula.getListaPelicula().incrementarDinero(datos, datos1);
						ListaPelicula.getListaPelicula().getPelicula(datos).imprimir();
						System.out.println(" ");
					}catch(Exception h ) {
						System.out.println("La pelicula no esta en la base de datos");
					}
					System.out.println("Ha tardado " + timer8.elapsedTime() + " segundos");
					System.out.println("Pulsa intro para continuar");
					sc.nextLine();
					break;
				case 8:
					System.out.println("--------------------------------------------------------------");
					System.out.println("| Obtener Actores de una pelicula                            |");
					System.out.println("|                                                            |");
					System.out.println("|Si no se encuentra la pelicula en la bd no devuelve Actores |");
					System.out.println("|Introduzca el nombre de la pelicula                         |");
					System.out.print("--------------------------------------------------------------   ");
					datos = sc.nextLine();
					StopWatch timer0 = new StopWatch();
					if (ListaPelicula.getListaPelicula().estaPeli(datos)) {
						Actor[] actor = ListaPelicula.getListaPelicula().obtenerActoresPelicula(new Pelicula(datos));
						System.out.print(datos + " Tiene los actores: ");
						for (int i = 0; i < actor.length; i++) {
							System.out.print(" " + actor[i].getNombre() + " && ");
						}
					}
					System.out.println("");
					System.out.println("Ha tardado " + timer0.elapsedTime() + " segundos");
					System.out.println("Pulsa intro para continuar");
					sc.nextLine();

					break;
				case 9:
					System.out.println("------------------------------------------------------------");
					System.out.println("| Crear Grafo                                              |");
					System.out.println("| creamoos el grafo con la lista de actores y peliculas    |");
					System.out.println("------------------------------------------------------------");
					StopWatch timer9 = new StopWatch();
					g.crearGrafo();
					grafoCreado = true;
					System.out.println("Ha tardado " + timer9.elapsedTime() + " segundos");
					System.out.println("Pulsa intro para Finalizar el programa");
					sc.nextLine();
					break;

				case 10:
						boolean bucle  = false;
						while(!bucle) {
							if (grafoCreado) {
								System.out.println("------------------------------------------------------------");
								System.out.println("| Recorrido por Anchura                                     |");
								System.out.println("| Si existe un recorrido lo mostrara                        |");
								System.out.println("------------------------------------------------------------");
								System.out.print("Introduca el nombre del primer Actor:");
								String a1 = sc.nextLine();
								System.out.print("Introduca el nombre del segundo Actor:");
								String a2 = sc.nextLine();
								StopWatch timer10 = new StopWatch();
								ArrayList<String> camino = g.recorridoEnAnchura(a1, a2);
								Iterator ipm = camino.iterator();
								System.out.println("");
								if(!camino.isEmpty()) {
									while (ipm.hasNext()) {
										System.out.print(ipm.next() + "  &  ");
									}
									System.out.println();
									System.out.println("");
								}else{
									System.out.println("Lo sentimos pero los dos actores no tienen relación");

								}
								System.out.println("Ha tardado " + timer10.elapsedTime() + " segundos");
								System.out.println("Pulsa intro para Finalizar el programa");
								sc.nextLine();
								bucle = true;
							} else {
								System.out.println("------------------------------------------------------------");
								System.out.println("| Crear Grafo                                              |");
								System.out.println("| creamoos el grafo con la lista de actores y peliculas    |");
								System.out.println("------------------------------------------------------------");
								StopWatch timer101 = new StopWatch();
								g.crearGrafo();
								grafoCreado = true;
								System.out.println("Ha tardado " + timer101.elapsedTime() + " segundos");
								System.out.println("Pulsa intro para continuar");
								sc.nextLine();
							}
						}
						break;
				case 11:
					boolean bucle2  = false;
					while(!bucle2) {
						if (grafoCreado) {
							System.out.println("------------------------------------------------------------");
							System.out.println("| Recorrido en Profundidad                                  |");
							System.out.println("| Si existe un recorrido lo mostrara                        |");
							System.out.println("------------------------------------------------------------");
							System.out.print("Introduca el nombre del primer Actor:");
							String a1 = sc.nextLine();
							System.out.print("Introduca el nombre del segundo Actor:");
							String a2 = sc.nextLine();
							StopWatch timer11 = new StopWatch();
							ArrayList<String> camino = g.recorridoEnProfundidad(a1, a2);
							Iterator ipm = camino.iterator();
							System.out.println("");
							if(!camino.isEmpty()) {
								while (ipm.hasNext()) {
									System.out.print(ipm.next() + "  &  ");
								}
								System.out.println();
								System.out.println("");
							}else{
								System.out.println("Lo sentimos pero los dos actores no tienen relación");
								}
							System.out.println("Ha tardado " + timer11.elapsedTime() + " segundos");
							System.out.println("Pulsa intro para Finalizar el programa");
							sc.nextLine();
							bucle2 = true;
						} else {
							System.out.println("------------------------------------------------------------");
							System.out.println("| Crear Grafo                                              |");
							System.out.println("| creamoos el grafo con la lista de actores y peliculas    |");
							System.out.println("------------------------------------------------------------");
							StopWatch timer101 = new StopWatch();
							g.crearGrafo();
							grafoCreado = true;
							System.out.println("Ha tardado " + timer101.elapsedTime() + " segundos");
							System.out.println("Pulsa intro para continuar");
							sc.nextLine();
						}
					}
					break;

				case 12:
					System.out.println("------------------------------------------------------------");
					System.out.println("| Imprimir grafo                                            |");
					System.out.println("------------------------------------------------------------");
					if(g.isEmpty()){
					    System.out.println("El grafo esta vacio");
                    }else {
                        g.print();
                    }
					break;

				case 13:
					System.out.println("------------------------------------------------------------");
					System.out.println("| Guardar datos y salir                                    |");
					System.out.println("| Guardamos actores en el archivo de Actores.txt           |");
					System.out.println("| creamos una base de datos como la proporcionada          |");
					System.out.println("------------------------------------------------------------");
					StopWatch timer11 = new StopWatch();
					ListaPelicula.getListaPelicula().guardarDatos();
					System.out.println("Ha tardado " + timer11.elapsedTime() + " segundos");
					salir = true;
					System.out.println("Pulsa intro para Finalizar el programa");
					sc.nextLine();
					break;
				}

			} catch (Exception e) {
				System.out.println("Uoop! Error!");
			}
		}
		sc.close();
	}
}
