package ar.com.codigomariano.domain;

import ar.com.codigomariano.enums.Categoria;

public class Binaria extends Pregunta {
	
	private boolean correcta;

	public Binaria(String codigo, String texto, Categoria categoria) {
		super(codigo, texto, categoria);
	}

}
