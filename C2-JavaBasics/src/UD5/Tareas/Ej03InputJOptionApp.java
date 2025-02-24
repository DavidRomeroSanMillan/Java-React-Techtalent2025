package UD5.Tareas;
import javax.swing.JOptionPane;

public class Ej03InputJOptionApp {

	public static void main(String[] args) {
		
		String welcome = "Bienvenido ";
		String nom = JOptionPane.showInputDialog("Introduce tu nombre");
		JOptionPane.showMessageDialog(null, welcome + nom);

	}

}
