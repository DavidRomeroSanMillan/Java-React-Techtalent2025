package UD05.Tareas;

import javax.swing.JOptionPane;

public class Ej05ParImparApp {

	
	public static void main(String[] args) {

		String num=JOptionPane
				.showInputDialog("Introduce el número");
		float numfl = Float.parseFloat(num);
		
			if ((numfl%2)==0) {JOptionPane.showMessageDialog(null, "El número " +num+" es par.");}
			else {JOptionPane.showMessageDialog(null, "El número " +num+" es impar.");}
		
		}

}
