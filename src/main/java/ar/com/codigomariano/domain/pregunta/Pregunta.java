package ar.com.codigomariano.domain.pregunta;

import ar.com.codigomariano.enums.Categoria;

public abstract class Pregunta {
	private String codigo;
	private String texto;
	private Categoria categoria;
	private int puntaje;
	
	public Pregunta(String codigo, String texto, Categoria categoria) {
		this.codigo = codigo;
		this.texto = texto;
		this.categoria = categoria;
	}
	public String getTexto() {
		return this.texto;
	}
	public abstract void mostrar();
	
	

}
