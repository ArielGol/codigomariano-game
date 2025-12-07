package ar.com.codigomariano;

import java.util.Scanner;

import ar.com.codigomariano.domain.Juego;
import ar.com.codigomariano.domain.Partida;
import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.domain.pregunta.Binaria;
import ar.com.codigomariano.domain.pregunta.Multiple;
import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import ar.com.codigomariano.enums.OpcionBinaria;
import ar.com.codigomariano.exceptions.EmailNotFoundException;

public class App {
	private static final int CANTIDAD=5;
	private static Scanner scanner=new Scanner(System.in);
	
    public static void main(String[] args) {
    	
    	Juego juego=new Juego();
    	solicitarEmail(juego);
    	iniciarPartida(juego);
    	try {
    		Multiple pregunta1=new Multiple("M01","¿En qué año se produjo el descubrimiento de América?",Categoria.HISTORIA,Opcion.A);
    		pregunta1.sumarOpcion(Opcion.A,"1492");
        	pregunta1.sumarOpcion(Opcion.B,"1516");
        	pregunta1.sumarOpcion(Opcion.C,"1671");
        	pregunta1.sumarOpcion(Opcion.D,"1744");
        	pregunta1.mostrar();
        	Binaria pregunta2=new Binaria("B01","¿El ajedrez es un deporte olímpico?",Categoria.DEPORTES,OpcionBinaria.B);
        	pregunta2.mostrar();
    	}catch(IllegalArgumentException ex) {
    		System.out.println("No se pudo crear la pregunta debido a que : "+ex.getMessage());
    	}
    
    
    	scanner.close();
    
    }
    
    private static void solicitarEmail(Juego juego) {
    	for (int i = 0; i < CANTIDAD; i++) {
    	boolean ingresado=false;
    		do {
    			String email=datoIngresadoPorConsola((i+1)+".Ingresar email: ");
        		try {
        			juego.agregarUsuario(email);
        			ingresado=true;
        		}catch(IllegalArgumentException ex) {
        			System.out.println("No se puede ingresar con este mail debido a: "+ex.getMessage());
        		}
    		}while(!ingresado);
    }
    }
    private static void iniciarPartida(Juego juego) {
    	boolean partidaIniciada=false;
    	do {
    		String emailPartida=datoIngresadoPorConsola("Ingrese email para iniciar partida:");
    		try {
				if(juego.existeUsuario(emailPartida)) {
					partidaIniciada=true;
					Usuario jugador=juego.buscarUsuario(emailPartida);
					System.out.println(jugador);
					Partida partida=new Partida(jugador);
					partida.mostrarInfoPartida();
				}
			} catch (EmailNotFoundException e) {
				System.out.println("No se pudo iniciar la partida debido a: "+e.getMessage());
			}
    	
    	}while(!partidaIniciada);
    }
    
    private static String datoIngresadoPorConsola(String texto) {
    	System.out.print(texto);
		String datoIngresado=scanner.nextLine();
		return datoIngresado;
    }
}