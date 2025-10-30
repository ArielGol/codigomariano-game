package ar.com.codigomariano.domain;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	private List<Pregunta> preguntas=new ArrayList<Pregunta>();
	private List<Usuario> usuarios=new ArrayList<Usuario>();
	
	
	public void agregarUsuario(String email) {
		if(email!=null) {
			Usuario usuario=new Usuario(email);
			usuarios.add(usuario);			
		}

	}
	public Usuario buscarUsuario(String email) {
		Usuario encontrado=null;
		int index=0;
		while(encontrado==null&&index<this.usuarios.size()) {
			Usuario u =this.usuarios.get(index);
			if(u.tieneEmail(email)) {
				encontrado=u;
			}
			index++;
		}
		return encontrado;
	}
	
	public boolean existeUsuario(String email) {
		Usuario usuario=buscarUsuario(email);
		return usuario!=null;
	}

	
}
