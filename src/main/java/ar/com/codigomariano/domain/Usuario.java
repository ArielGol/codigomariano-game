package ar.com.codigomariano.domain;

public class Usuario {
	private static final int MIN_LENGTH=15;
	private static final int MAX_LENGTH=75;
	private static final String EMAIL_ERR="El mail del usuario debe tener entre 15 y 75 caracteres.";
	private static final String EMAIL_INVALID="El mail no debe ser nulo ni vacio";
	private static final String EMAIL_FORMATO="El formato del mail no es válido";
	//private static int next_id=1;
	private Integer id;
	private String email;
	
	
	public Usuario (String email) {
		setEmail(email);
		//this.id=next_id;
		//next_id++;
	}
	
	public boolean tieneEmail(String email) {
		return this.email.equals(email);
	}
	
	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return "Usuario [ID=" + this.id + "| EMAIL=" + this.email + "]";
	}
	
	public void setEmail(String email) {
		if(email==null|| email.isBlank()) {
			throw new IllegalArgumentException(EMAIL_INVALID);
		}else if(email.length()<MIN_LENGTH||email.length()>MAX_LENGTH) {
			throw new IllegalArgumentException(EMAIL_ERR);
		}else if(!email.contains("@")) {
			throw new IllegalArgumentException(EMAIL_FORMATO);
		}
		this.email=email;
	}
	
	

}
