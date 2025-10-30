package ar.com.codigomariano.domain;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class Multiple extends Pregunta {
	
	private Opcion correcta;
	private Opcion[] opciones=new Opcion[Opcion.values().length];
	

	public Multiple(String codigo, String texto, Categoria categoria) {
		super(codigo, texto, categoria);
	}

}
