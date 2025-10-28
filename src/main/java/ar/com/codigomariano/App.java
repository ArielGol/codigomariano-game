package ar.com.codigomariano;

import java.util.Scanner;

import ar.com.codigomariano.domain.Juego;
import ar.com.codigomariano.domain.Partida;
import ar.com.codigomariano.domain.Usuario;

public class App {
	private static Scanner scanner=new Scanner(System.in);
	private static final int CANTIDAD=5;
	
    public static void main(String[] args) {
    	
    	Juego juego=new Juego();
    	solicitarEmail(juego);
    	iniciarPartida(juego);
    	scanner.close();
    
    }
    
    private static void solicitarEmail(Juego juego) {
    	for(int i=1;i<=CANTIDAD;i++) {
    		String email=datoIngresadoPorConsola((i)+".Ingresar email: ");
    		juego.agregarUsuario(email);
    	}
 
    }
    
    private static void iniciarPartida(Juego juego) {
    	boolean partidaIniciada=false;
    	do {
    		String emailPartida=datoIngresadoPorConsola("Ingrese email para iniciar partida:");
    		if(juego.existeUsuario(emailPartida)) {
        		partidaIniciada=true;
        		Usuario jugador=juego.buscarUsuario(emailPartida);
        		Partida partida=new Partida(jugador);
        		partida.mostrarInfoPartida();
    		}
    	
    	}while(!partidaIniciada);
    }
    
    private static String datoIngresadoPorConsola(String texto) {
    	System.out.print(texto);
		String datoIngresado=scanner.nextLine();
		return datoIngresado;
    }
}