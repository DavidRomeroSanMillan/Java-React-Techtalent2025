package UD06.Tareas;


import javax.swing.JOptionPane;

public class Ej05DecimalBinarioApp {

	public static void main(String[] args) {

		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número: "));
		JOptionPane.showMessageDialog(null, "El binario de " 
										+ numero + " es: " + binario(numero));

	}

	public static String binario(int numero) {
		String stringNumero = Integer.toBinaryString(numero);
		return stringNumero;
	
	
	}

}
