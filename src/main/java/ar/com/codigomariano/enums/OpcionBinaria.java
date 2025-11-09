package ar.com.codigomariano.enums;

public enum OpcionBinaria {
	A('a',"Verdadero"),
	B('b',"Falso");
	
	private char opcion;
	private String texto;
	
	private OpcionBinaria(char opcion,String texto) {
		this.opcion=opcion;
		this.texto=texto;
	}
	@Override
	public String toString() {
		return this.opcion+". "+this.texto;
	}
	
	

}
