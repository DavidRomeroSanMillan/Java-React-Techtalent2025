package UD06.Tareas;

import javax.swing.JOptionPane;

public class Ej01PoliAreaApp {

	public static void main(String[] args) {
		String poligono = JOptionPane.showInputDialog("Elige un polígono entre circulo, triangulo y cuadrado: ");
		switch (poligono.toLowerCase()) {
		case "circulo":
			double radio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el radio del círculo: "));
			JOptionPane.showMessageDialog(null,
					"El área de un círculo de " + radio + " de radio es: " + circulo(radio));
			break;
		case "triangulo":
			double base = Double.parseDouble(JOptionPane.showInputDialog("Introduce la base del triángulo: "));
			double altura = Double.parseDouble(JOptionPane.showInputDialog("Introduce la altura del triángulo: "));
			JOptionPane.showMessageDialog(null, "El área de un triángulo de " + base + " de base y " + altura
					+ " de altura es de: " + triangulo(base, altura));
			break;
		case "cuadrado":
			double lado = Double.parseDouble(JOptionPane.showInputDialog("Introduce el lado del cuadrado: "));
			JOptionPane.showMessageDialog(null,
					"El área de un cuadrado de " + lado + " de lado es de: " + cuadrado(lado));
			break;
		}

	}

	private static double cuadrado(double lado) {

		return (lado * 2);
	}

	private static double triangulo(double base, double altura) {

		return ((base * altura) / 2);
	}

	private static double circulo(double radio) {
		return (Math.PI * Math.pow(radio, 2));

	}

}
