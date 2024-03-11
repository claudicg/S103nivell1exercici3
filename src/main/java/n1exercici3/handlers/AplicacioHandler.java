package n1exercici3.handlers;

import java.util.Scanner;

import n1exercici3.utils.Constants;

public class AplicacioHandler {

	private JugadorHandler jhandler = new JugadorHandler();
	private PartidaHandler partida = new PartidaHandler();
	

	private void instruccionsJoc(){
		 
		System.out.println("Per pantalla et mostraré el nom d'un pais.");
		System.out.println("Hauràs de respondre quina és la seva capital.");
		System.out.println("Per cada encert, guanyaràs " + Constants.ReglesJoc.PUNT_ENCERT + " punt.");
		System.out.println("Et preguntaré " +  Constants.ReglesJoc.NUM_COUNTRIES_ASK + " països");
	}
	
	private void iniciarJoc() {
		
		System.out.println("Començem ...");
		jhandler.preguntarNom();
		jhandler.saludarJugador();
	}
	
	private int jugar() {
		
		Scanner entrada = new Scanner(System.in);
		int contador = 0;
		for(int i = 1; i <= Constants.ReglesJoc.NUM_COUNTRIES_ASK; i++) {
			
			String country = partida.agafarKeyAleatoria();
			System.out.println(Constants.Preguntes.CAPITALS + country + "?");
			String capital = entrada.nextLine().trim();
			
			if(partida.trobarCapital(country).equalsIgnoreCase(capital)) {
				System.out.println(Constants.Dialegs.RESP_CORRECTE);
				System.out.println("La capital de " + country + " és " + capital);
				contador++;
			}else {
				System.out.println(Constants.Dialegs.RESP_INCORRECTE);
				System.out.println("La capital de " + country + " és " + partida.trobarCapital(country));
			}
			
		}
		entrada.close();
		return contador;
	}
	
	
	private void tancarJoc(int contador) {
		
		jhandler.registrarPuntuacio(contador);
		
		if(contador <=5) {
			System.out.println(Constants.Dialegs.PUNTUACIO_MENOR5);
		}else if(contador > 5 && contador < 8) {
			System.out.println(Constants.Dialegs.PUNTUACIO_ENTRE5_7);
		}else if(contador >= 8 && contador <= 9) {
			System.out.println(Constants.Dialegs.PUNTUACIO_MAXIMA);
		}
		System.out.println(Constants.Dialegs.ADEU);
		
		
	}
	
	public void executarJoc() {
		
		instruccionsJoc();
		iniciarJoc();
		tancarJoc(jugar());
		jhandler.guardarRegistre();
	}
	
}