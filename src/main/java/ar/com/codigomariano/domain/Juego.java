package ar.com.codigomariano.domain;

import java.util.ArrayList;
import java.util.List;

import ar.com.codigomariano.domain.pregunta.Pregunta;
import ar.com.codigomariano.exceptions.EmailNotFoundException;

public class Juego {
	private List<Pregunta> preguntas=new ArrayList<Pregunta>();
	private List<Usuario> usuarios=new ArrayList<Usuario>();
	
	
	public void agregarUsuario(String email) {
			Usuario usuario=new Usuario(email);
			usuarios.add(usuario);			
	}
	
	public Usuario buscarUsuario(String email) throws EmailNotFoundException {
		Usuario encontrado=null;
		int index=0;
		while(encontrado==null&&index<this.usuarios.size()) {
			Usuario u =this.usuarios.get(index);
			if(u.tieneEmail(email)) {
				encontrado=u;
			}
			index++;
		}
		if(encontrado==null) {
			throw new EmailNotFoundException(email);
		}
		return encontrado;
	}
	
	public boolean existeUsuario(String email) throws EmailNotFoundException {
		Usuario usuario=buscarUsuario(email);
		return usuario!=null;
	}

	
}
