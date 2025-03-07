package UD06.Tareas;

import javax.swing.JOptionPane;

public class Ej02NumeroAleatorioApp {

	public static void main(String[] args) {

		int numVeces = Integer
				.parseInt(JOptionPane.showInputDialog("¿Cuantos números aleatorios quieres?"));
		int i = 1;
		
		int min = Integer
				.parseInt(JOptionPane.showInputDialog("¿Qué mínimo quieres?"));
		int max = Integer
				.parseInt(JOptionPane.showInputDialog("¿Qué máximo quieres?"));
		while (i <= numVeces) {
			
		JOptionPane.showMessageDialog(null, "¡Te ha tocado el número: " + aleatorio(min, max) + "!");
		i++;}
	}

	private static int aleatorio(int min, int max) {
	
		int random = (int) (Math.random() * ((max - min) + 1)) + min;
		return random;

	}

}
