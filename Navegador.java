package uF6.ejercicios.practica1.navegadorPersistenteConsola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

// SOLO USAR: listas (List), conjuntos (Set), mapas o diccionarios (Map)

public class Navegador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String URL;
	private Stack<String> pilaAtras = new Stack<String>();
	private Stack<String> pilaAdelante = new Stack<String>();
	//No permite objetos que sean iguales por medio de la url.
	private Set<Favoritos> favoritos = new HashSet<Favoritos>(); // no dejara agregar objetos con la misma url
	private Favoritos listaFavoritos; // servira para poder saber si la pagina ya ha sido agregada
	private ArrayList<Historial> historial = new ArrayList<Historial>();
	private HashMap<String, Integer> visitas = new HashMap<String, Integer>();
	

	// CONSTRUCTOR
	public Navegador() {
		this.URL = "https://www.google.com"; // pagina por defecto
	}

	// SETTER Y GETTER
	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public Stack<String> getPilaAtras() { 
		//Navegador.mostrarPila(firefox.getPilaEnrere()); 
		return pilaAtras;
	}

	public Stack<String> getPilaAdelante() { 
		//Navegador.mostrarPila(firefox.getPilaEndavant()); 
		return pilaAdelante;
	}

	public HashMap<String, Integer> getVisitas() {
		return visitas;
	}

	public void setVisitas(HashMap<String, Integer> visitas) {
		this.visitas = visitas;
	}
	
	
	// METODOS

	// Opcion 1
	public void anarA(String novaURL) { // va a la pagina web indicada
		pilaAtras.push(URL); // agrega la pagina a la pilaAtras
		this.URL = "https://";
		this.URL = URL + novaURL;// Mostrada la pagina actual.
		if (!pilaAdelante.empty()) {
			pilaAdelante.clear();
		}
		historial.add(new Historial(URL));// Crea y agrega los datos al historial	
		cantidadVisitas(); //Contara la cantidad de visitas
	}
	
	// Opcion 2
	public void enrere() { // muestra la pagina web anterior
		if (!pilaAtras.empty()) { // verifica si la pila esta vacia para que continua hacia atras
			pilaAdelante.push(URL);
			URL = pilaAtras.pop();
			historial.add(new Historial(getURL()));// Crea y agrega los datos al historial
			cantidadVisitas();
		}else {
			System.out.println("\tNo hay mas paginas para atras");
		}
	}

	// Opcion 3
	public void endavant() {// muestra la pagina web posterior
		if (!pilaAdelante.empty()) {
			pilaAtras.push(URL);
			URL = pilaAdelante.pop();
			historial.add(new Historial(getURL()));// Crea y agrega los datos al historial
			cantidadVisitas();
		}else {
			System.out.println("\tNo hay mas paginas para adelante");
		}
	}

	// Opcion 4
	public void afegirPreferit(String url) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("\tIngrese Descripcion: ");
		String detalle = sc.nextLine();// guarda la descripcion de la pagina
		listaFavoritos = new Favoritos(url, detalle);
		boolean existe = favoritos.contains(listaFavoritos);// verifica si ya esta guardada la pagina
		if (existe) {
			System.out.println("\tLa pagina ya ha sido agregada.");
		}else {
			favoritos.add(listaFavoritos);
			System.out.println("\tPagina agregada: " + url);
		}
	}

	// Opcion 5
	public void eliminarPreferits(String url) {		
		// Se pasa favoritos a un iterador para poder borrar mientras se recorre la lista
		Iterator<Favoritos> iterator = favoritos.iterator();
		while (iterator.hasNext()){// mientras alla un siguiente mas adelante sigue
			// verifica el nombre que hay en cada objeto
		    String nombreURL = iterator.next().getNombreURL();
		    if(nombreURL.equals(url)){//comprueba si son iguales
		        iterator.remove();// remueve el objeto con el nombre de url igual
		        System.out.println("\tPagina borrada: " + url);
		    }
		}
	}

	// Opcion 6
	public void veurePreferits() {
		System.out.println("\nLISTA DE PAGINAS FAVORITAS");
		System.out.println("===============================");
		if (favoritos.isEmpty()) {
			System.out.println("No hay favoritos.");
		} else {
			for (Favoritos favorito : favoritos) {
				System.out.println(favorito);
			}
		}
		System.out.println("==============================="); 
	}

	// Opcion 7
	public void veureHistorial() {
		System.out.println("\n=====================HISTORIAL========================");
		for (Historial listaHistorial : historial) {
			System.out.println(listaHistorial);
		}
		System.out.println("\n======================================================");
	}

	// Opcion 8
	public void veureVisitades() {
		System.out.println(visitas);
		//System.out.println("Pagina: " + visitas.keySet() + "=" + visitas.values()); 
	}
	
	
	private void cantidadVisitas() {
		if (visitas.containsKey(URL)) {// buscara la clave
            visitas.put(URL, visitas.get(URL) + 1);// si la contiene aumenta la cantidad de visista
        } else { // si no la agrega a la lista con su valor 1
            visitas.put(URL, 1);
        }
	}



	// Funcionamiento de las pilas, se podra ver en la consola
	public static void mostrarPila(Stack<String> pilas) {
		for (String string : pilas) {
			System.out.println(string);
		}
	}

	
}
