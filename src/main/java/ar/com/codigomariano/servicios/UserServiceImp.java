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
	
	public void guardarUsuario(Usuario user) {
		// validaciones, logica previa a la persistencia
		this.repository.save(user);
	}
	
	public Usuario obtener(Long id) {
		Usuario user;
		user =this.repository.getReferenceById(id);
		return user;
	}

	@Override
	public boolean existsUser(String email) {
		boolean exists=false;
		if(email !=null) {
			List<Usuario> usuarios=this.repository.findByEmail(email);
			exists=usuarios.isEmpty();
		}
		return false;
	}
	
}
