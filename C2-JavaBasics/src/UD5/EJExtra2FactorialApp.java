package UD5;

import javax.swing.JOptionPane;
public class EJExtra2FactorialApp {

	public static void main(String[] args) {
//		2Factorial d'un número
//		 Descripció: Escriu un programa que calculi el factorial d'un número introduït per teclat.
//		Recorda que el factorial de n és n! = n × (n-1) × ... × 1.
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número: "));
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			
			factorial = factorial*i;
	
		}
		JOptionPane.showMessageDialog(null, "El factorial de "+n+" es: "+factorial);
		
	}

}
