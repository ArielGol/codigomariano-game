package ar.com.codigomariano.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.repositorios.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	//Aca implemento metodos de negocio
	
	public Usuario guardarUsuario(Usuario user) {
		return this.repository.save(user);
	}
	
	@Override
	public Usuario obtener(Long id) {
	    return this.repository.findById(id).orElse(null);
	}

	@Override
	public boolean existsUser(String email) {
	    if (email != null) {
	        List<Usuario> usuarios = this.repository.findByEmail(email);
	        return !usuarios.isEmpty(); // ! porque si la lista NO está vacía, existe
	    }
	    return false;
	}
	
}
