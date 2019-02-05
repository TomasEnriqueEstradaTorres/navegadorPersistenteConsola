package uF6.ejercicios.practica1.navegadorPersistenteConsola;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchivoNavegador {
	
	//ESTA CLASE SE ENCARGARA DE LA PERSISTENCIA DE DATOS

	//Funcion para serializar los datos guardandolo en un archivo
	public void guardar(Navegador navegador)  {
		try {
			//asigna nombre al archivo
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("datosNavegador.ser"));
			salida.writeObject(navegador);// agrega el objeto al archivo
			salida.close();// cierra el objeto
		} catch (IOException a) {
			a.printStackTrace();
		}		
	}
	
	
	//Funcion para recuperar los datos aqui se realizada la deserializacion 
	public Navegador recuperar(){
		
		Navegador navegador = null;
		try {
			//se busca el objeto a deserializar
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("datosNavegador.ser"));
			// Se lee el objeto guardado y se realiza un casting para adatarlo a la clase Navegador
			navegador = (Navegador) entrada.readObject();
			entrada.close();
		} catch (IOException b) {
			b.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		// devolvera un objeto de tipo Farmacia con los datos en su interior para luego usarlos en la persistencia
		return navegador;
	}
	
}
