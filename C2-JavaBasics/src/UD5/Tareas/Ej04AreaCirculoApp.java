package UD5.Tareas;

import javax.swing.JOptionPane;

public class Ej04AreaCirculoApp {

	public static void main(String[] args) {
		
		String radio=JOptionPane.showInputDialog("Introduce el radio");
		double numDouble = Double.parseDouble(radio);
		
		JOptionPane.showMessageDialog(null, "El área de un círculo de "
				+radio+" de radio es de "+(Math.PI*Math.pow(numDouble, 2)));
		
		
		
		
	}

}
