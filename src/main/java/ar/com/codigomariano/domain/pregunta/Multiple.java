package ar.com.codigomariano.domain.pregunta;


import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class Multiple extends Pregunta {
	
	private Opcion correcta;
	private String[] opciones;
	
	

	public Multiple(String codigo, String texto, Categoria categoria) {
		super(codigo, texto, categoria);
		this.opciones=new String[Opcion.values().length];
	}
	
	public void agregarOpciones(int posicion,String texto) {
		this.opciones[posicion]=texto; 
	}


	
	public void mostrar() {
		String textoPregunta=getTexto();
		System.out.println(textoPregunta);
		for (int i = 0; i < opciones.length; i++) {
			sumarOpcion(Opcion.values()[i],opciones[i]);
		}
		
	}
	
	public void sumarOpcion(Opcion letra,String texto ) {
		System.out.println(letra.caracter()+"."+texto);
	}

}
