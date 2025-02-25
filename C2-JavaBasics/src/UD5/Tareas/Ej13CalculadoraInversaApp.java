package UD5.Tareas;

import javax.swing.JOptionPane;

public class Ej13CalculadoraInversaApp {

	public static void main(String[] args) {

		int a = Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer número: "));
		String b = JOptionPane.showInputDialog("Introduce el símbolo aritmético: ");
		int c = Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo número: "));

		if (b.equals("+")) {
			JOptionPane.showMessageDialog(null, "El resultado de " + a + " + " + c + " es: " + (a + c));
		} else if (b.equals("-")) {
			JOptionPane.showMessageDialog(null, "El resultado de " + a + " - " + c + " es: " + (a - c));
		} else if (b.equals("*")) {
			JOptionPane.showMessageDialog(null, "El resultado de " + a + " * " + c + " es: " + (a * c));
		} else if (b.equals("/")) {
			JOptionPane.showMessageDialog(null,
					"El resultado de " + a + " / " + c + " es: " + ((double) a / (double) c));
		} else if (b.equals("^")) {
			JOptionPane.showMessageDialog(null, "El resultado de " + a + " ^ " + c + " es: " + (Math.pow(a, c)));
		} else if (b.equals("%")) {
			JOptionPane.showMessageDialog(null, "El resultado de " + a + " % " + c + " es: " + (a % c));
		} else {
			JOptionPane.showMessageDialog(null, "Introduce un símbolo aritmético correcto");
		}

	}

}
