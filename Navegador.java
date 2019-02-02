package uF6.ejercicios.practica1.navegadorPersistenteConsola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;


class Navegador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	final static String DEFAULT_URL = "www.jaumebalmes.net";

    static void mostrarPila(Stack<String> pila) {
        System.out.println(pila);
    }

    private String url;
    private Stack<String> pilaEnrere;
    private Stack<String> pilaEndavant;
    //Historial
    private ArrayList<Historial> historial;
    //Visitades
    private HashMap<String, Integer> visites;
    //Preferits
    private TreeSet<Preferit> preferits;

    //CONSTRUCTORES
    public Navegador() {
        this(DEFAULT_URL);
    }
    
    public Navegador(String url) {
        this.url = url;
        pilaEnrere = new Stack<>();
        pilaEndavant = new Stack<>();
        historial = new ArrayList<>();
        visites = new HashMap<String, Integer>();
        preferits = new TreeSet<>();
        afegirAHistorial();
        actualitzarVisitades();
        //afegir url a historial i a visitats
    }


    //SETTER Y GETTER
    public String getURL() {
        return url;
    }

    public Stack<String> getPilaEnrere() {
        return pilaEnrere;
    }

    public Stack<String> getPilaEndavant() {
        return pilaEndavant;
    }

    public ArrayList<Historial> getHistorial() {
        return historial;
    }

    public HashMap<String, Integer> getVisites() {
        return visites;
    }

    public TreeSet<Preferit> getPreferits() {
        return preferits;
    }

  
    // METODOS
    public void anarA(String novaURL) {
        pilaEnrere.push(url);
        url = novaURL;
        if (!pilaEndavant.empty()) {
            pilaEndavant.clear();
        }
        afegirAHistorial();
        actualitzarVisitades();
    }

    public void enrere() {
        if (!pilaEnrere.empty()) {
            pilaEndavant.push(url);
            url = pilaEnrere.pop();
            afegirAHistorial();
            actualitzarVisitades();
        }
    }

    public void endavant() {
        if (!pilaEndavant.empty()) {
            pilaEnrere.push(url);
            url = pilaEndavant.pop();
            afegirAHistorial();
            actualitzarVisitades();
        }
    }

    public void afegirPreferit(String url) {
        if (!preferits.contains(new Preferit(url, ""))) {
            preferits.add(new Preferit(url, "sense descripcio"));
        }
    }

    public void eliminarPreferits(String url) {
        if (preferits.contains(new Preferit(url, ""))) {
            preferits.remove(new Preferit(url, ""));
        }
    }

    public void veurePreferits() {
        System.out.println(preferits);
    }

    public void veureHistorial() {
        System.out.println(historial);
    }

    public void veureVisitades() {
        System.out.println(visites);
    }

    private void afegirAHistorial() {
        historial.add(new Historial(url));
    }

    private void actualitzarVisitades() {
        if (visites.containsKey(url)) {
            visites.put(url, visites.get(url) + 1);
        } else {
            visites.put(url, 1);
        }
    }

}
