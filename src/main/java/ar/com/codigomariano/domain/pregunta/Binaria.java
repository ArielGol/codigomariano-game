package ar.com.codigomariano.domain.pregunta;


import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import ar.com.codigomariano.enums.OpcionBinaria;

public class Binaria extends Pregunta<OpcionBinaria> {
	
	private OpcionBinaria correcta;

	public Binaria(String codigo, String texto, Categoria categoria) {
		this(codigo,texto,categoria,PUNTOS_POR_DEFECTO);
	}
	
	public Binaria(String codigo, String texto, Categoria categoria,int puntos) {
		super(codigo, texto, categoria, puntos);
		}



	@Override
	protected OpcionBinaria[] inicializarOpciones() {
		return new OpcionBinaria[] {OpcionBinaria.A,OpcionBinaria.B};
	}
	

}
