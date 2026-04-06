package ar.com.codigomariano.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class Usuario extends Persistible {
	private static final int MIN_LENGTH=15;
	private static final int MAX_LENGTH=75;
	private static final String EMAIL_ERR="El mail del usuario debe tener entre 15 y 75 caracteres.";
	private static final String EMAIL_INVALID="El mail no debe ser nulo ni vacio";
	private static final String EMAIL_FORMATO="El formato del mail no es válido";
	//private static int next_id=1;
	
	@Column(name="Email")
	private String email;
	
	//Just for Hibernate
	Usuario(){
	}
	
	
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
		return "Usuario [ID=" + getId() + "| EMAIL=" + this.email + "]";
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
