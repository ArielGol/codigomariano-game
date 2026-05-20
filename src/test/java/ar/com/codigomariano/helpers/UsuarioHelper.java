package ar.com.codigomariano.helpers;

import java.util.Random;

import ar.com.codigomariano.domain.Usuario;

public class UsuarioHelper {

	public static final String VALID_USER_EMAIL="codigomariano@gmail.com";
	private static final Random random=new Random(System.currentTimeMillis());
	private static final char[] caracteres=new char[] {'a','b','c','d'};
	
	public final static Usuario createValidUser() {
		return new Usuario(VALID_USER_EMAIL);
	}
	
	public final static String createMail() {
		return "mail_"+random.nextInt()+"@mail.com";
	}
	
	public final static String createMail(int cantCaracteres) {
		String email="@mail.com";
		int cantidad=cantCaracteres -email.length();
		
		for(int i=0; i<cantidad;i++) {
			int posicion=random.nextInt(caracteres.length);
			email=caracteres[posicion]+email;
		}		
		return email;
	}
}
