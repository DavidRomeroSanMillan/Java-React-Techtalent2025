package UD06.Tareas;

import javax.swing.JOptionPane;

public class Ej04FactorialApp {

	public static void main(String[] args) {

		int n = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número: "));

		JOptionPane.showMessageDialog(null, "El factorial de " + n + " es: " + factorial(n));


		}
		

	public static int factorial(int n) {
		int factorial = 1;
		for (int i = 2; i <= n; i++) {

			factorial = factorial * i;
		}
		return factorial;
	}

}
