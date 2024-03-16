package n1exercici3.beans;

public class Jugador {
	
	private String nom = "";
	private int puntuacio;
	
	public Jugador() {
		super();	
	} 
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getPuntuacio() {
		return puntuacio;
	}

	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}


	@Override
	public String toString() {
		return "Jugador [nom=" + nom + ", puntuacio=" + puntuacio + "]";
	}

	
}
