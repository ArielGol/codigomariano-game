package ar.com.codigomariano.enums;

public enum Categoria {
	GEOGRAFIA("geography"),
	ARTE_Y_LITERATURA("art and literature"),
	ENTRETENIMIENTO("entertainment"),
	CIENCIA("nature"),
	DEPORTES("leisure"),
	HISTORIA("history");
	
	private String clave;
	
	private Categoria(String clave) {
		this.clave=clave;
	}
	
	public String clave() {
		return this.clave;
	}

}
