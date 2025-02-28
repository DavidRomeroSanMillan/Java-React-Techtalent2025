package UD05.Tareas;

import javax.swing.JOptionPane;

public class Ej12ContraseñasApp {

	public static void main(String[] args) {

		String contraseña = "1234";
		String pass = "";
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
//break sirve para salir de un bucle
//.equals sirve para comparar dos cadenas de texto
//do while se ejecuta al menos una vez