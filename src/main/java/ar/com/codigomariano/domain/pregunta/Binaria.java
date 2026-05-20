package ar.com.codigomariano.domain.pregunta;


import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import ar.com.codigomariano.enums.OpcionBinaria;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
@Entity
@Table(name="BINARIAS")
public class Binaria extends Pregunta {
	@Column(name = "Correcta")
	@Enumerated(EnumType.ORDINAL)
	private OpcionBinaria correcta;
	
	
	private OpcionBinaria[] opciones;
	
	//Just for Hibernate
	protected Binaria(){
		super();
	}

	public Binaria(String codigo, String texto, Categoria categoria,OpcionBinaria correcta) {
		this(codigo,texto,categoria,PUNTOS_POR_DEFECTO,correcta);
	}
	

	public Binaria(String codigo, String texto, Categoria categoria,int puntos,OpcionBinaria correcta) {
		super(codigo, texto, categoria, puntos);
		setCorrecta(correcta);
		this.opciones=new OpcionBinaria[] {OpcionBinaria.A,OpcionBinaria.B};
	}

	@Override	
	public void mostrar() {
		for (int i = 0; i < opciones.length; i++) {
			System.out.println(Opcion.values()[i]+"."+opciones[i]);
		}
	}
	
	public boolean esRespuestaCorrecta(OpcionBinaria opcionSeleccionada) {
		return this.correcta.equals(opcionSeleccionada);
	}
	private void setCorrecta(OpcionBinaria correcta) {
		if(correcta==null) throw new IllegalArgumentException(CORRECTA_ERR);
		this.correcta = correcta;
	}


}
