package UD06.Tareas;

import javax.swing.JOptionPane;

public class Ej02NumeroAleatorioApp {

	public static void main(String[] args) {

		int numVeces = Integer
				.parseInt(JOptionPane.showInputDialog("¿Cuantos números aleatorios entre el 5 y el 50 quieres?"));
		int i = 1;
		while (i <= numVeces) {
			
		JOptionPane.showMessageDialog(null, "¡Te ha tocado el número: " + aleatorio() + "!");
		i++;}
	}

	private static int aleatorio() {
		int min = 5;
		int max = 50;
		int random = (int) (Math.random() * ((max - min) + 1)) + min;
		return random;

	}

}
