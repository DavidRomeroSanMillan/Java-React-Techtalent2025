package UD5;

import javax.swing.JOptionPane;

public class UD5PruebaContraseñaApp {

	public static void main(String[] args) {

		String contraseña = "1234";
		String pass = " ";
		int intentos = 3;

		do {
			pass = JOptionPane.showInputDialog("Introduce la contraseña: ");
			if (pass.equals(contraseña)) {
				JOptionPane.showMessageDialog(null, "¡Enhorabuena!");
				break;

			} else {
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
			}

			intentos--;
		} while (intentos > 0);

	}

}
