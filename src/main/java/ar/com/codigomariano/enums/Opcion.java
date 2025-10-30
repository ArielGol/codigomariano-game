package ar.com.codigomariano.enums;

public enum Opcion {
	A('a'),
	B('b'),
	C('c'),
	D('d');
	
	private char caracter;
	
	private Opcion(char c) {
		this.caracter=c;
	}
	
	public char caracter() {
		return this.caracter;
	}
	

}
