package ar.com.codigomariano.enums;

public enum OpcionBinaria {
	A('a',true,"Verdadero"),
	B('b',false,"Falso");
	
	private char letra;
	private boolean opcion;
	private String texto;
	
	private OpcionBinaria(char letra,boolean opcion,String texto) {
		this.letra=letra;
		this.opcion=opcion;
		this.texto=texto;
	}
	
	@Override
	public String toString() {
		return this.texto;
	}
	
	
	

}
