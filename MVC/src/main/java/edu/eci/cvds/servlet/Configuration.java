package edu.eci.cvds.servlet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Configuration {
	@Id
	private String propiedad;
	private String valor;
	
	public String  getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public Configuration(){
		
	}
	public Configuration(String propiedad, String valor) {
        this.propiedad = propiedad;
        this.valor = valor;

	}
	
}
