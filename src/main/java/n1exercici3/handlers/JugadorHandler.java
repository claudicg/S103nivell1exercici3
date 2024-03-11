package n1exercici3.handlers;

import java.util.Scanner;
import n1exercici3.beans.Jugador;
import n1exercici3.utils.Constants;
import n1exercici3.utils.WriterUtils;

public class JugadorHandler {
	
	private Scanner entrada = new Scanner(System.in);
	private Jugador jugador = new Jugador();
	
	public void preguntarNom() {
		
		System.out.println("Escriu el teu nom: ");
		String nomJugador = entrada.nextLine().trim();
		jugador.setNom(nomJugador);	
	}
	
	public void saludarJugador() {
		
		System.out.println("Hola " + jugador.getNom().toUpperCase() + Constants.Dialegs.SALUTACIO);
	}
	
	
	public void registrarPuntuacio(int contador) {
		
		jugador.setPuntuacio(contador);
		System.out.println(jugador.getNom().toUpperCase() + Constants.Dialegs.PUNTUACIO_FINAL + 
				contador + " punts.");
	
	}
	
	public void guardarRegistre() {
		
		String registre = jugador.toString();
		String path = Constants.File.PATH;
		String fileName = Constants.File.CATEGORIES_FILE;
		
		WriterUtils.escriureArxius(registre, path,fileName );
		
		
	}
	
}
