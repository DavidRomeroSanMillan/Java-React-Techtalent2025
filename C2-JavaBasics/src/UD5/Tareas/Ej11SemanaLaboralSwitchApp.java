package UD5.Tareas;

import javax.swing.JOptionPane;

public class Ej11SemanaLaboralSwitchApp {

	public static void main(String[] args) {
		String DiaSemana = JOptionPane.showInputDialog("Introduce un día de la semana: ");
		switch (DiaSemana.toUpperCase()) {
		case "LUNES":
			System.out.println("Lunes es laboral");
			break;
		case "MARTES":
			System.out.println("Martes es laboral");
			break;
		case "MIERCOLES":
			System.out.println("Miércoles es laboral");
			break;
		case "JUEVES":
			System.out.println("Jueves es laboral");
			break;
		case "VIERNES":
			System.out.println("Viernes es laboral");
			break;
		case "SABADO":
			System.out.println("Sábado es laboral");
			break;
		case "DOMINGO":
			System.out.println("Domingo no es laboral");
			break;
		default:
			System.out.println("Día no válido");
			break;

		}
	}

}
