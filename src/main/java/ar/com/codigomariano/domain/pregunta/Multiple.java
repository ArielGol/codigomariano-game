package ar.com.codigomariano.domain.pregunta;


import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class Multiple extends Pregunta<String> {
	
	private String correcta;
	
	

	public Multiple(String codigo, String texto, Categoria categoria) {
		this(codigo,texto,categoria,PUNTOS_POR_DEFECTO);
	}
	public Multiple(String codigo, String texto, Categoria categoria,int puntos) {
		super(codigo, texto, categoria,puntos);
	}
	


	
	public void sumarOpcion(Opcion letra,String texto ) {
			super.asignar(letra, texto);
	}
	@Override
	protected String[] inicializarOpciones() {
		return new String[Opcion.values().length];
	}

}
