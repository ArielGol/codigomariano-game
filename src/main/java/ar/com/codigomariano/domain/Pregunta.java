package ar.com.codigomariano.domain;

import ar.com.codigomariano.enums.Categoria;

public class Pregunta {
	private String codigo;
	private String texto;
	private Categoria categoria;
	
	public Pregunta(String codigo, String texto, Categoria categoria) {
		this.codigo = codigo;
		this.texto = texto;
		this.categoria = categoria;
	}
	
	

}
