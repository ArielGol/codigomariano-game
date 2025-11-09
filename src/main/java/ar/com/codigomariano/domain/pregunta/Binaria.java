package ar.com.codigomariano.domain.pregunta;


import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import ar.com.codigomariano.enums.OpcionBinaria;

public class Binaria extends Pregunta {
	
	private OpcionBinaria[] opciones;
	private boolean correcta;

	public Binaria(String codigo, String texto, Categoria categoria) {
		super(codigo, texto, categoria);
		this.opciones=new OpcionBinaria[] {OpcionBinaria.A,OpcionBinaria.B};
	}

	public void mostrar() {
		String textoPregunta=getTexto();
		System.out.println(textoPregunta);
		for (OpcionBinaria opcionBinaria : opciones) {
			System.out.println(opcionBinaria);
		}
	}

}
