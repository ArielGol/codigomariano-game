package ar.com.codigomariano.domain;

public class Usuario {
	private static int next_id=1;
	private Integer id;
	private String email;
	
	public Usuario (String email) {
		this.email=email;
		this.id=this.next_id;
		this.next_id++;
	}

	

}
