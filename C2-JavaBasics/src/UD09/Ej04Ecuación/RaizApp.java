package UD09.Ej04Ecuación;

public class RaizApp {

	public static void main(String[] args) {
		try {
			Raices Prueba1 = new Raices(134, 78, 11);
			// Si la a es = 0 da error.
			Prueba1.calcular();
		} catch (IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
