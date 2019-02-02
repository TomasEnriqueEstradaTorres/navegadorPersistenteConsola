/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uF6.ejercicios.practica1.navegadorPersistenteConsola;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author pguitart
 */
class Preferit implements Comparable<Preferit>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String url;
    private String descripcio;

    public Preferit(String url, String descripcio) {
        this.url = url;
        this.descripcio = descripcio;
    }

    public String getUrl() {
        return url;
    }

    public String getDescripcio() {
        return descripcio;
    }

    @Override
    public String toString() {
        return "Preferit{" + "url=" + url + ", descripcio=" + descripcio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Preferit other = (Preferit) obj;
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Preferit o) {
        return this.url.compareTo(o.url);
    }
    
    
    
    
}
