package UD5;

import javax.swing.JOptionPane;

public class EjExtra1PrimosApp {

	public static void main(String[] args) {

		// Pedir un número al usuario
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));

		// Comprobar si el número es primo
		boolean esPrimo = true;
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				esPrimo = false;
				break;
			}
		}

		// Mostrar el resultado
		if (esPrimo) {
			JOptionPane.showMessageDialog(null, "El número " + numero + " es primo");
		} else {
			JOptionPane.showMessageDialog(null, "El número " + numero + " no es primo");
		}

	}
}
