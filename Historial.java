/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uF6.ejercicios.practica1.navegadorPersistenteConsola;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author pguitart
 */
class Historial implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private String url;
    private LocalDateTime data;

    public Historial(String url) {
        this.url = url;
        data = LocalDateTime.now();
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Historial{" + "url=" + url + ", data=" + data + '}';
    }
    
    
}
