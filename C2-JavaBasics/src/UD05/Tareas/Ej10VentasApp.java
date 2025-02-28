package UD05.Tareas;

import javax.swing.JOptionPane;

public class Ej10VentasApp {

	public static void main(String[] args) {

		int numVentas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de ventas: "));

		double valorVenta = 0, sumaTotal = 0;
		int i = 1;

		while (i <= numVentas) {
			valorVenta = Double.parseDouble(JOptionPane.showInputDialog("Introduce un valor " + i + " de la venta"));
			sumaTotal = sumaTotal + valorVenta;
			i++;

		}
		JOptionPane.showMessageDialog(null, "" + "La suma total es: " + sumaTotal);
	}

}
