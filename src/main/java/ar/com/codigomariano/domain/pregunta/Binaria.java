package ar.com.codigomariano.domain.pregunta;


import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import ar.com.codigomariano.enums.OpcionBinaria;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name="BINARIAS")
@DiscriminatorValue(value=Binaria.DISCRIMINATOR_VALUE)
public class Binaria extends Pregunta<OpcionBinaria,OpcionBinaria> {
	
	public static final String DISCRIMINATOR_VALUE ="binaria";
	
	//Just for Hibernate
	Binaria(){}

	public Binaria(String codigo, String texto, Categoria categoria,OpcionBinaria correcta) {
		this(codigo,texto,categoria,PUNTOS_POR_DEFECTO,correcta);
	}
	
	public Binaria(String codigo, String texto, Categoria categoria,int puntos,OpcionBinaria correcta) {
		super(codigo, texto, categoria, puntos, correcta);
		}



	@Override
	protected OpcionBinaria[] inicializarOpciones() {
		return new OpcionBinaria[] {OpcionBinaria.A,OpcionBinaria.B};
	}
	

}
