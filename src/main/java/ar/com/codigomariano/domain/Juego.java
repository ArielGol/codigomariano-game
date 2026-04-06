package ar.com.codigomariano.domain;

import java.util.ArrayList;
import java.util.List;

import ar.com.codigomariano.domain.pregunta.Pregunta;
import ar.com.codigomariano.exceptions.EmailNotFoundException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="JUEGOS")
public class Juego extends Persistible {
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="PREGUNTAS_JUEGOS",joinColumns = @JoinColumn(name="Juego_id"),
			inverseJoinColumns = @JoinColumn(name="Pregunta_id"))
	
	private List<Pregunta> preguntas=new ArrayList<Pregunta>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Juego_id",referencedColumnName = "ID")
	private List<Usuario> usuarios=new ArrayList<Usuario>();
	
	//Just for Hibernate
	Juego(){}
	
	
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
