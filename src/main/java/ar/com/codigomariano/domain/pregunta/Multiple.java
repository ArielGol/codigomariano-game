package ar.com.codigomariano.domain.pregunta;


import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name="MULTIPLES")
@DiscriminatorValue(value=Multiple.DISCRIMINATOR_VALUE)
public class Multiple extends Pregunta<String,Opcion> {
	
	public static final String DISCRIMINATOR_VALUE ="MULTIPLE";
	
	//Just for Hibernate
	Multiple(){}

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
