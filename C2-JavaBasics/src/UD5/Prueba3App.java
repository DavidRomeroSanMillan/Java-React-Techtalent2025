package UD5;
import javax.swing.JOptionPane;

public class Prueba3App {

	public static void main(String[] args) {
		
		String welcome = "Bienvenido ";
		String nom = JOptionPane.showInputDialog("Introduce tu nombre");
		JOptionPane.showMessageDialog(null, welcome + nom);

	}

}
