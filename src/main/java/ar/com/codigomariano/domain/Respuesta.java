package ar.com.codigomariano.domain;

import ar.com.codigomariano.enums.Opcion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="RESPUESTAS")
public class Respuesta extends Persistible {
	
	protected static final String ERR_TEXTO="El texto de la respuesta no puede ser nulo";
	
	@Column(name = "TEXTO")
	private String texto;
	
	@Column(name = "CORRECTA")
	private Boolean correcta;
	
	public Boolean getCorrecta() {
		return correcta;
	}

	public void setCorrecta(Boolean correcta) {
		this.correcta = correcta;
	}

	//Just for Hibernate
	protected Respuesta() {
		super();
	}
	
	public Respuesta(String texto) {
		this(texto,Boolean.FALSE);
	}
	
	public Respuesta(String texto, Boolean respuestaCorrecta) {
		setTexto(texto);
		setCorrecta(respuestaCorrecta);
	}
	
	public void mostrarRespuesta(Opcion opcion) {
		System.out.println(opcion+"."+this.texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	

}
