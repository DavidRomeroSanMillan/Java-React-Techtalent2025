package UD06.Tareas;

import javax.swing.JOptionPane;

public class Ej03BooleanPrimoApp {

	public static void main(String[] args) {

		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));

		if (esPrimo(numero)) {
			JOptionPane.showMessageDialog(null, "El número " + numero + " es primo");
		} else {
			JOptionPane.showMessageDialog(null, "El número " + numero + " no es primo");
		}

	}

	public static boolean esPrimo(int numero) {
		boolean esPrimo = true;
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				esPrimo = false;
				break;
			}
		}
		return esPrimo;

	}

}
