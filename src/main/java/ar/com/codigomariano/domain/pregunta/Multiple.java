package ar.com.codigomariano.domain.pregunta;


import java.util.ArrayList;
import java.util.List;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import ar.com.codigomariano.domain.Respuesta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="MULTIPLES")
public class Multiple extends Pregunta {
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pregunta_id",referencedColumnName="ID",nullable=false)
	private List<Respuesta> respuestas;
	
	//Just for Hibernate
	protected Multiple(){
		super();
	}

	public Multiple(String codigo, String texto, Categoria categoria) {
		this(codigo,texto,categoria,PUNTOS_POR_DEFECTO);
	}
	public Multiple(String codigo, String texto, Categoria categoria,int puntos) {
		super(codigo, texto, categoria,puntos);
		this.respuestas=new ArrayList<Respuesta>();
	}
	
	public void agregarRespuesta(String texto) {
	    this.respuestas.add(new Respuesta(texto)); // correcta=false por defecto
	}

	public void agregarRespuesta(String texto, Boolean esCorrecta) {
	    this.respuestas.add(new Respuesta(texto, esCorrecta));
	}
	
	public boolean esCorrecta(Opcion opcion) {
	    int index = opcion.ordinal();
	    if (index >= respuestas.size()) return false;
	    return respuestas.get(index).getCorrecta(); // necesitás getCorrecta() en Respuesta
	}
	@Override
	public void mostrar() {
	    System.out.println(getTexto());
	    Opcion[] opciones = Opcion.values();
	    for (int i = 0; i < respuestas.size(); i++) {
	        respuestas.get(i).mostrarRespuesta(opciones[i]);
	    }
		
	}

}
