package ar.com.codigomariano.domain.pregunta;

import ar.com.codigomariano.domain.Pregunta;
import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class Multiple extends Pregunta {
	
	private Opcion correcta;
	private Opcion[] opciones=new Opcion[Opcion.values().length];
	

	public Multiple(String codigo, String texto, Categoria categoria) {
		super(codigo, texto, categoria);
	}


	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

}
