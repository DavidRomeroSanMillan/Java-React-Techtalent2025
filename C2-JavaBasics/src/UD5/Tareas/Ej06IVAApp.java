package UD5.Tareas;

import javax.swing.JOptionPane;

public class Ej06IVAApp {

	public static void main(String[] args) {
		
		final double IVA=0.21;
		String texto_num=JOptionPane
					.showInputDialog("Introduce el precio del producto");
		
		int precio=Integer.parseInt(texto_num);
		JOptionPane.showMessageDialog(null, "El producto tiene un precio sin IVA"
				+ " de "+precio+" y con IVA es de "+(precio+(precio*IVA)));
		

	}

}
