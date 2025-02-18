package UD5;

import java.util.Scanner;

public class UD5ScannerApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //abro recurso INPUT
		
		System.out.println("Bienvenido a JAVA");
		System.out.println("Introduce tu nombre");
		
		String name = sc.nextLine(); //Pedimos al usuario un valor de texto referente a su nombre.
		sc.close();
		
		System.out.println("Hola " + name.toUpperCase() + ".");
	}

}
