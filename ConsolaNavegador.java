
package uF6.ejercicios.practica1.navegadorPersistenteConsola;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import muestras.persistenciaDatos2.ArchiFarmacia;
import muestras.persistenciaDatos2.Farmacia;
import muestras.persistenciaDatos2.Medicamento;

public class ConsolaNavegador {

    //opciones menu principal
    final static int ENTRAR_URL = 1;
    final static int ENRERE = 2;
    final static int ENDAVANT = 3;
    final static int AFEGIR_PREFERITS = 4;
    final static int ELIMINAR_PREFERITS = 5;
    final static int VEURE_PREFERITS = 6;
    final static int VEURE_HISTORIAL = 7;
    final static int VEURE_VISITADES = 8;
    final static int SORTIR = 0;

    /**Mostra el menú principal de la aplicación.      */
    public static void mostrarMenuPrincipal() {
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("1. Anar a: ");  // ir a
        System.out.println("2. Enrere");  // atras
        System.out.println("3. Endavant"); // adelante
        System.out.println("4. Afegir a adreces d'interes");  // Añadir a direcciones de interes
        System.out.println("5. Eliminar d'adreces d'interes");  // Eliminar a direcciones de interes
        System.out.println("6. Veure adreces d'interes");  // Ver direcciones de interes
        System.out.println("7. Veure historial");  //  Ver historial
        System.out.println("8. Veure nombre visites");  // Ver número visitas
        System.out.println("0. Sortir");
        System.out.print("\tOpcion: ");
    }
    
    /**Lee un entero que representa una opción de menos.
     * @return un entero, -1 si la entrada no se numerica      */
    public static int llegirOpcio() {
        Scanner lector = new Scanner(System.in);
        int opcio = 0;
        try {
            opcio = Integer.parseInt(lector.nextLine());
        } catch (NumberFormatException e) {
            opcio = -1;
        }
        return opcio;
    }
    
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	
    	ArchivoNavegador archivoNavegador = new ArchivoNavegador();
    	
        Navegador firefox = new Navegador();
        int opcio;
        
        do {
        	System.out.println("\n===========NAVEGADOR===========");
            System.out.println(firefox.getURL());  // muestra la pagina actual.
            System.out.println("\n===============================");
            System.out.println("\n----------------------------------------");
            System.out.println("ADELANTE:");
            Navegador.mostrarPila(firefox.getPilaEndavant());  //pila Adelante
            System.out.println("----------------------------------------");
            System.out.println("ATRAS:"); 
            Navegador.mostrarPila(firefox.getPilaEnrere());  //pila Atras 
            System.out.println("----------------------------------------");
            mostrarMenuPrincipal();  //Muestra el menu de opciones00
            opcio = llegirOpcio(); // sirve para elegir una opcion del menu
            switch (opcio) {
                case ENTRAR_URL:
                    String novaURL = llegirURL();
                    firefox.anarA(novaURL); // ir a / va a la pagina web indicada
                    
                    File file = new File("datosNavegador.ser");
                    if (file.exists()) {
                    	Navegador recu = recuperar(); 
                    	System.out.println("a1: " + recu.getURL());
                    	System.out.println("a2: " + recu.getHistorial());
                    	System.out.println("a3: " + recu.getPreferits());
                    	System.out.println("a4: " + recu.getPilaEndavant());
                    	System.out.println("a5: " + recu.getPilaEnrere());
                    	System.out.println("a6: " + recu.getVisites());
      
                    	System.out.println("Datos recuperados");
						
					} else {
						
						 guardar(firefox);
						 System.out.println("Datos guardados");
					}
                    
                    
                   
                    break;
                case ENRERE: // Atras
                    firefox.enrere(); // 
                    break;
                case ENDAVANT: // Adelante
                    firefox.endavant(); // para adelante 
                    break;
                case AFEGIR_PREFERITS:  //Añadir a favoritos
                    firefox.afegirPreferit(firefox.getURL());
                    break;
                case ELIMINAR_PREFERITS://Eliminar favoritos
                    firefox.eliminarPreferits(firefox.getURL());
                    break;
                case VEURE_PREFERITS://Ver favoritos
                    firefox.veurePreferits();
                    break;
                case VEURE_HISTORIAL://Ver historial
                    firefox.veureHistorial();
                    break;
                case VEURE_VISITADES:// Ver visitadas
                    firefox.veureVisitades();
                    break;
                case SORTIR:
                    break;    
                default:
                    System.out.println("Opcio incorrecta");
                    break;
            }
        } while (opcio != SORTIR);
    }
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------
    
    
    /**Pide un código de barras hasta que se entre un valor no vacío.
     * @return código de barras no vacío      */
    public static String llegirURL() {
        String URL;
        Scanner lector = new Scanner(System.in);

        do {
            System.out.print("\nURL: ");
            URL = lector.nextLine();
        } while (URL.isEmpty());

        return URL;
    }
    
    
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------
    
    
    public static void guardar(Navegador navegador) throws IOException{
		//Objeto para implementar la persistencia: Guardar objeto Navegador en archivo
    	ArchivoNavegador archivoNavegador = new ArchivoNavegador();
    	archivoNavegador.guardar(navegador);
		System.out.println("Almacenamiento Correcto");
	}
    
    
    
    public static Navegador recuperar()throws IOException, ClassNotFoundException {
		// Onjeto para implementar la persistencia: Recuperar objeto Navegador archivo
    	ArchivoNavegador archivoNavegador = new ArchivoNavegador();
    	Navegador recuperar = archivoNavegador.recuperar();
		return recuperar;
	}
    
    
    
    
    

}
