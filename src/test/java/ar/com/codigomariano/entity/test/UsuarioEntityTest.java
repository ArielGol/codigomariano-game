package ar.com.codigomariano.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.helpers.UsuarioHelper;

public class UsuarioEntityTest {
	
	@Test
	public void testTieneEmailSuccess() {
		Usuario u = UsuarioHelper.createValidUser();
		assertTrue(u.tieneEmail(UsuarioHelper.VALID_USER_EMAIL));
	}
	@Test
	public void testTieneEmailFailure() {
		Usuario u = UsuarioHelper.createValidUser();
		assertFalse(u.tieneEmail(UsuarioHelper.createMail()));
	}
	
	@Test
	public void testEmailMenorA15Caracteres() {
		try {
			new Usuario(UsuarioHelper.createMail(10));
			fail("El usuario no puede construirse con un mail menor a 15 caracteres");
		}catch(IllegalArgumentException e) {
		
		}
		
	}

}
