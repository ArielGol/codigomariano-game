package ar.com.codigomariano.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import ar.com.codigomariano.domain.pregunta.Pregunta;
import ar.com.codigomariano.enums.Categoria;

public class Partida {
	private final int CANT_PREGUNTAS=10;
	private Date fechaPartida;
	private Pregunta[][] preguntas=new Pregunta[Categoria.values().length][CANT_PREGUNTAS];
	private Usuario jugador;
	private static final String USUARIO_ERR="El jugador no debe ser nulo";
	
	public Partida(Usuario jugador) {
		setJugador(jugador);
		this.fechaPartida=new Date();
		this.preguntas=new Pregunta[Categoria.values().length][CANT_PREGUNTAS];
	}
	
	public void mostrarInfoPartida() {
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String mensaje="Se inició una partida para el jugador %s ,el %s.";
		String mensajeFormateado=String.format(mensaje,this.jugador.getEmail(),formatter.format(this.fechaPartida));
		System.out.println(mensajeFormateado);

	}
	private void setJugador(Usuario jugador) {
		if(jugador==null) throw new IllegalArgumentException(USUARIO_ERR);
		this.jugador=jugador;
	}


	
}
