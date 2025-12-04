package ar.com.codigomariano.domain.pregunta;


import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import ar.com.codigomariano.enums.OpcionBinaria;

public class Binaria extends Pregunta<OpcionBinaria,OpcionBinaria> {

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
