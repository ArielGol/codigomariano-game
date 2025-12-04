package ar.com.codigomariano.enums;

public enum OpcionBinaria {
	A('a',"Verdadero"),
	B('b',"Falso");
	
	private char letra;
	private String texto;
	
	private OpcionBinaria(char letra,String texto) {
		this.letra=letra;
		this.texto=texto;
	}
	
	@Override
	public String toString() {
		return this.texto;
	}
	
	
	

}
