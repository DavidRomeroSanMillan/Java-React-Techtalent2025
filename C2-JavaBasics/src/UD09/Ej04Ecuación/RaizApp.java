package UD09.Ej04Ecuación;

public class RaizApp {

	public static void main(String[] args) {
		try {
		Raices Prueba1 = new Raices (1, 2, 1);
//		System.out.println(Prueba1.getDiscriminante());
//		System.out.println(Prueba1.tieneRaices());
//		System.out.println(Prueba1.tieneRaiz());
		//Si la a es = 0 da error.
		Prueba1.calcular();
	}catch (IllegalArgumentException e) {
		System.err.println("Error: "+e.getMessage());
	}
	}
}
