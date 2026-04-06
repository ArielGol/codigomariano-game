package ar.com.codigomariano.domain.pregunta;

import ar.com.codigomariano.domain.Persistible;
import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "PREGUNTAS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "discriminator",discriminatorType = DiscriminatorType.STRING)
public abstract class Pregunta<O,T> extends Persistible {
	protected final static int PUNTOS_POR_DEFECTO=100;
	private static final String CODIGO_ERR="El código no debe ser nulo ni vacío.";
	private static final String TEXTO_ERR="El texto no debe ser nulo ni vacío.";
	private static final String CATEGORIA_ERR="La categoría no debe ser nula.";
	private static final String CORRECTA_ERR="La opción correcta no debe ser nula.";
	@Column(name="Codigo")
	private String codigo;
	
	@Column(name="Texto")
	private String texto;
	
	@Column(name="Categoria_id")
	@Enumerated(EnumType.ORDINAL)
	private Categoria categoria;
	
	@Column(name="Puntaje")
	private int puntaje;
	
	@Column(name="Opciones")
	private String opcionesPersistidas;
	
	@Transient
	private O[] opciones;
	
	
	@Column(name="Correcta")
	@Enumerated(EnumType.STRING)
	private T correcta;
	
	//Just for Hibernate
	Pregunta(){}
	
	
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
