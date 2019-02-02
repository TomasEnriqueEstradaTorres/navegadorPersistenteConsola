package uF6.ejercicios.practica1.navegadorPersistenteConsola;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystemNotFoundException;

public class ArchivoNavegador {
	
	//ESTA CLASE SE ENCARGARA DE LA PERSISTENCIA DE DATOS

	//Funcion para serializar los datos guardandolo en un archivo
	public void guardar(Navegador navegador) throws FileSystemNotFoundException, IOException {
		//asigna nombre al archivo
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("datosNavegador.ser"));
		salida.writeObject(navegador);// agrega el objeto al archivo
		salida.close();// cierra el objeto
	}
	
	
	//Funcion para recuperar los datos aqui se realizada la deserializacion 
	public Navegador recuperar() throws IOException, ClassNotFoundException{
		//se busca el objeto a deserializar
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("datosNavegador.ser"));
		// Se lee el objeto guardado y se realiza un casting para adatarlo a la clase Navegador
		Navegador navegador = (Navegador) entrada.readObject();
		entrada.close();
		// devolvera un objeto de tipo Farmacia con los datos en su interior para luego usarlos en la persistencia
		return navegador;
	}

}
