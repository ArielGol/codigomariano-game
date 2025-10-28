package ar.com.codigomariano.domain;

import java.util.Date;

import ar.com.codigomariano.enums.Categoria;

public class Partida {
	private final int CANT_PREGUNTAS=10;
	private Date fechaPartida;
	private Pregunta[][] preguntas=new Pregunta[Categoria.values().length][CANT_PREGUNTAS];
	private Usuario jugador;
	
	public Partida(Usuario jugador) {
		this.jugador=jugador;
		this.fechaPartida=new Date();
		this.preguntas=new Pregunta[Categoria.values().length][CANT_PREGUNTAS];
	}
	
	public void mostrarInfoPartida() {
		String mensaje="Se inició una partida para el jugador <%s> ,el %te de %tB de %tY, a las %tH:%tM:%tS.";
		String mensajeFormateado=String.format(mensaje,this.jugador.getEmail(),this.fechaPartida,this.fechaPartida,this.fechaPartida,this.fechaPartida,this.fechaPartida,this.fechaPartida);
		System.out.println(mensajeFormateado);

	}


	
}
