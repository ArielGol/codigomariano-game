package ar.com.codigomariano.domain.pregunta;


import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class Multiple extends Pregunta<String,Opcion> {
	

	public Multiple(String codigo, String texto, Categoria categoria,Opcion correcta) {
		this(codigo,texto,categoria,PUNTOS_POR_DEFECTO,correcta);
	}
	public Multiple(String codigo, String texto, Categoria categoria,int puntos, Opcion correcta) {
		super(codigo, texto, categoria,puntos,correcta);
	}
	


	
	public void sumarOpcion(Opcion letra,String texto ) {
			super.asignar(letra, texto);
	}
	@Override
	protected String[] inicializarOpciones() {
		return new String[Opcion.values().length];
	}

}
