package UD04;

public class Ejercicio1App {

	public static void main(String[] args) {
		float a = 5, b = 10, suma, resta, div, multi, mod;
		mod = a % b;
		resta = a - b;
		multi = a * b;
		suma = a + b;
		div = a / b;
		System.out.println("El resultado de 5+10 es " + suma + ", de 5-10 es " + resta + ", " + "de 5*10 es " + multi
				+ ", de 5/10 es " + div + " y de 5%10 es " + mod);
	}

}
