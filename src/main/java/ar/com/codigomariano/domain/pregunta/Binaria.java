package ar.com.codigomariano.domain.pregunta;

import ar.com.codigomariano.domain.Pregunta;
import ar.com.codigomariano.enums.Categoria;

public class Binaria extends Pregunta {
	
	private boolean correcta;

	public Binaria(String codigo, String texto, Categoria categoria) {
		super(codigo, texto, categoria);
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

}
