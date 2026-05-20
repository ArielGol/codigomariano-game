package ar.com.codigomariano.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.helpers.UsuarioHelper;
import ar.com.codigomariano.servicios.UserService;


@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService servicio;
	
	@Test
	public void testSaveUsuarioSucess() {
		Usuario u=UsuarioHelper.createValidUser();
		
		this.servicio.guardarUsuario(u);
	}

    @Test
    public void testObtenerUsuarioExistente() {
        Usuario u = UsuarioHelper.createValidUser();
        Usuario guardado = this.servicio.guardarUsuario(u);
        Usuario resultado = this.servicio.obtener(guardado.getId());

        assertNotNull(resultado);
        assertEquals(guardado.getId(), resultado.getId());
        assertEquals(guardado.getEmail(), resultado.getEmail());
    }

    @Test
    public void testObtenerUsuarioInexistente() {
        Usuario resultado = this.servicio.obtener(-1L);

        assertNull(resultado);
    }


    @Test
    public void testExistsUserEmailExistente() {
        Usuario u = UsuarioHelper.createValidUser();
        this.servicio.guardarUsuario(u);

        boolean existe = this.servicio.existsUser(u.getEmail());

        assertTrue(existe);
    }

    @Test
    public void testExistsUserEmailInexistente() {
        boolean existe = this.servicio.existsUser("noexiste@mail.com");

        assertFalse(existe);
    }
}


