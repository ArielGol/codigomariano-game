package ar.com.codigomariano.domain.pregunta;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public abstract class Pregunta<T> {
	private String codigo;
	private String texto;
	private Categoria categoria;
	private int puntaje;
	protected final static int PUNTOS_POR_DEFECTO=100;
	private T[] opciones;
	
	
	//Este es el constructor más generico
	public Pregunta(String codigo, String texto, Categoria categoria,int puntos) {
		this.codigo = codigo;
		this.texto = texto;
		this.categoria = categoria;
		this.puntaje=puntos;
		this.opciones=inicializarOpciones();
	}
	
	
	protected abstract T[] inicializarOpciones();
	
	protected void asignar(Opcion opcion,T valor) {
		this.opciones[opcion.ordinal()]=valor;
	}

	
	public void mostrar() {
		System.out.println(this.texto);
		for (int i = 0; i < opciones.length; i++) {
			System.out.println(Opcion.values()[i]+"."+opciones[i]);
		}
		
	}
	
	

}
