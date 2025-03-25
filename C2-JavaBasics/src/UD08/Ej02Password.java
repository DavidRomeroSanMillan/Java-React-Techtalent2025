package UD08;
import java.util.Random;
import javax.swing.JOptionPane;

public class Ej02Password {
	//Això són els atributs que guardaran els valors
	private String password;
	private int longitud;
	//Constructor per defecte que posa la longitud a 8 
	//i agafa la password del mètode aleatori
	public Ej02Password () {
		this.longitud=8;
		this.password= generarPassword(this.longitud);
	}
	//Constructor que demana la longitud a l'usuari i genera la password 
	public Ej02Password(int longitud) {
		this.longitud=Integer.parseInt(JOptionPane.showInputDialog
						(null, "Ingresa la longitud de la contraseña:"));
		this.password= generarPassword(this.longitud);
	}
	//Mètode que genera una contrasenya en String a partir d'una sel·lecció aleatòria
	//de chars (constant) i ho passa per un append de StringBuilder per unificar-ho en un sol String.
	//El bucle agafa un número de chars aleatoris de la llista igual a longitud, 8 per defecte o l'input de l'usuari
	//Va agafant caràcters de la llista fent servir charAt i el mètode Random que indica la posició del caràcter a agafar.
	private String generarPassword(int longitud2) {
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefgh"
							+ "ijklmnopqrstuvwxyz0123456789!$%&?¿+-_";
		Random random = new Random ();
		StringBuilder sb = new StringBuilder(longitud2);
		
		for (int i = 0; i < longitud2; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
	//Retorna la contrasenya random com a String
		return sb.toString();
	}
	//Mètode per mostrar la longitud i la password
	public void mostrar () {
		System.out.println("La longitud es " + this.longitud + 
							" y la contraseña es: " +this.password);
	}
	//Mètode getter de password
	public String getPassword() {
		return password;
	}
	//Mètode getter de longitud
	public int getLongitud() {
		return longitud;
	}
}

