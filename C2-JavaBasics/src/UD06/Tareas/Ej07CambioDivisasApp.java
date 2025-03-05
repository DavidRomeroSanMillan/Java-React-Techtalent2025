package UD06.Tareas;

import javax.swing.JOptionPane;

public class Ej07CambioDivisasApp {

	public static void main(String[] args) {

	String divisa = JOptionPane.showInputDialog("Elige una divisa entre dolar, libra y yen: ");
	double dinero = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad: "));
	
	
	switch (divisa.toLowerCase()) {
	case "dolar":
		JOptionPane.showMessageDialog(null,
				"El cambio de " +dinero+ " euros a dólares es de " + dolar(dinero));
		break;
	case "libra":
		
		JOptionPane.showMessageDialog(null, "El cambio de " +dinero+ " euros a libras es de " + libra(dinero));
		break;
	case "yen":
		
		JOptionPane.showMessageDialog(null,
				"El cambio de " +dinero+ " euros a yenes es de " + yen(dinero));
		break;
	default:
		JOptionPane.showMessageDialog(null, "Introduce una divisa de las incluidas");
	}
		
	}

	public static double dolar (double dinero) {
		double dolar = dinero * 1.28611;
		return dolar;
	}
	public static double libra (double dinero) {
		double libra = dinero * 0.86;
		return libra;
		
	}
	public static double yen (double dinero) {
		double yen = dinero * 129.852;
		return yen;
	}
	
	
}
