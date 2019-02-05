package uF6.ejercicios.practica1.navegadorPersistenteConsola;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Historial implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String NombreURL;
	private LocalDate fechaActual;
	private LocalTime hora;
	
	//CONSTRUCTOR
	public Historial(String nombreURL) {
		this.NombreURL = nombreURL;
		this.fechaActual = LocalDate.now();
		this.hora = LocalTime.now();
	}
	
	
	//GETTER Y SETTER
	public String getNombreURL() {
		return NombreURL;
	}

	public LocalDate getFechaActual() {
		return fechaActual;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setNombreURL(String nombreURL) {
		NombreURL = nombreURL;
	}

	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}


	//METODOS
	@Override
	public String toString() {
		return "\nURL: " + NombreURL + 
				"\nFecha: " + fechaActual + 
				" - Hora: " + hora.getHour() + ":" + hora.getMinute()+ ":" + hora.getSecond();
	}
	

	
	

}
