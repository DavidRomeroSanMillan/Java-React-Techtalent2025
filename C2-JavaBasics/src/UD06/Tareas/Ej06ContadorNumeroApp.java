package UD06.Tareas;

import javax.swing.JOptionPane;

public class Ej06ContadorNumeroApp {

	public static void main(String[] args) {

		String numero = "";

		do {
			numero = JOptionPane.showInputDialog("Introduce un número entero positivo: ");
		} while (Integer.parseInt(numero) < 0);

		JOptionPane.showMessageDialog(null, "Este número tiene " + contador(numero) + " cifras.");
	}

	public static int contador(String numero) {
		int numContador = numero.length();
		return numContador;

	}

}
