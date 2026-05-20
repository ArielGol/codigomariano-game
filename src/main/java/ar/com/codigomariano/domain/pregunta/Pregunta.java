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
public abstract class Pregunta extends Persistible {
	protected final static int PUNTOS_POR_DEFECTO=100;
	private static final String CODIGO_ERR="El código no debe ser nulo ni vacío.";
	private static final String TEXTO_ERR="El texto no debe ser nulo ni vacío.";
	private static final String CATEGORIA_ERR="La categoría no debe ser nula.";
	protected static final String CORRECTA_ERR="La opción correcta no debe ser nula.";
	@Column(name="Codigo")
	private String codigo;
	
	@Column(name="Texto")
	private String texto;
	
	@Column(name="Categoria_id")
	@Enumerated(EnumType.ORDINAL)
	private Categoria categoria;
	
	@Column(name="Puntaje")
	private int puntaje;
	
	
	//Just for Hibernate
	Pregunta(){}
	
	
	public Pregunta(String codigo, String texto, Categoria categoria,int puntos) {
		setCodigo(codigo);
		setTexto(texto);
		setCategoria(categoria);
		this.puntaje=puntos;
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

	

		public String getTexto() {
		return texto;
	}


		public abstract void mostrar();
}
