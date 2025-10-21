package ar.com.codigomariano.enums;

public enum Categoria {
	GEOGRAFIA("geography"),
	ARTE_Y_LITERATURA("art and literature"),
	ENTRETENIMIENTO("entertainment"),
	CIENCIA("nature"),
	DEPORTES("leisure"),
	HISTORIA("history");
	
	private String key;
	
	private Categoria(String key) {
		this.key=key;
	}
	
	public String key() {
		return this.key;
	}

}
