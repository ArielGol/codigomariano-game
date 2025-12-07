package ar.com.codigomariano.domain.pregunta;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public abstract class Pregunta<O,T> {
	protected final static int PUNTOS_POR_DEFECTO=100;
	private static final String CODIGO_ERR="El código no debe ser nulo ni vacío.";
	private static final String TEXTO_ERR="El texto no debe ser nulo ni vacío.";
	private static final String CATEGORIA_ERR="La categoría no debe ser nula.";
	private static final String CORRECTA_ERR="La opción correcta no debe ser nula.";
	private String codigo;
	private String texto;
	private Categoria categoria;
	private int puntaje;
	private O[] opciones;
	private T correcta;
	
	
	public Pregunta(String codigo, String texto, Categoria categoria,int puntos,T correcta) {
		setCodigo(codigo);
		setTexto(texto);
		setCategoria(categoria);
		setCorrecta(correcta);
		this.puntaje=puntos;
		this.opciones=inicializarOpciones();
	}
	
	
	protected void asignar(Opcion opcion,O valor) {
		this.opciones[opcion.ordinal()]=valor;
	}

	
	public void mostrar() {
		System.out.println(this.texto);
		for (int i = 0; i < opciones.length; i++) {
			System.out.println(Opcion.values()[i]+"."+opciones[i]);
		}
		
	}
	
	public boolean esRespuestaCorrecta(T opcionSeleccionada) {
		return this.correcta.equals(opcionSeleccionada);
	}


	private void setCodigo(String codigo) {
		if(codigo==null||codigo.isBlank()) throw new IllegalArgumentException(CODIGO_ERR);
		this.codigo = codigo;
	}


	private void setTexto(String texto) {
		if(texto==null||texto.isBlank()) throw new IllegalArgumentException(TEXTO_ERR);
		this.texto = texto;
	}


	private void setCategoria(Categoria categoria) {
		if(categoria==null) throw new IllegalArgumentException(CATEGORIA_ERR);
		this.categoria = categoria;
	}


	private void setCorrecta(T correcta) {
		if(correcta==null) throw new IllegalArgumentException(CORRECTA_ERR);
		this.correcta = correcta;
	}
	
	//Todo metodo abstracto al final
		protected abstract O[] inicializarOpciones();
		

}
