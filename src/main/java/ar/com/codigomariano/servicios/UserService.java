package ar.com.codigomariano.servicios;

import ar.com.codigomariano.domain.Usuario;

public interface UserService {
	
	public void guardarUsuario(Usuario u);
	
	public Usuario obtener(Long id);
	
	public boolean existsUser(String email);

}
