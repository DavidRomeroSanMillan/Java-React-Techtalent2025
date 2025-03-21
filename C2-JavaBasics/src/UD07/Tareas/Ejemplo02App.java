package UD07.Tareas;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejemplo02App {

	public static void main(String[] args) {
		double IVA = 0.21; // Inicialització de l'IVA
		Scanner sc = new Scanner(System.in); // Inicialització de Scanner per fer servir a diferents mètodes
		ArrayList<Double> carrito = new ArrayList<>(); // ArrayList per guardar els preus

		//Mètodes
		ingresePrecios(sc, carrito); // Recopila els preus per posar al carrito
		double[] resultados = seleccionarIVA(sc, carrito); // Sel·lecció de l'IVA i càlcul dels preus totals
		IVA = resultados[0]; //S'actualitza l'IVA inicialitzat 
		double suma = resultados[1]; // Suma el preu brut
		double totalconIVA = resultados[2]; // Total del preu net
		resumen(IVA, suma, totalconIVA, carrito); // Mostra el resum de la compra
		pagoYcambio(sc, totalconIVA); // Es gestiona el pagament i el càlcul del canvi
	}

	
	public static void ingresePrecios(Scanner sc, ArrayList<Double> carrito) {
		System.out.println("Ingrese el precio de los productos uno por uno (escriba -1 para terminar):");
		while (true) {
			double precio = sc.nextDouble(); 
			if (precio == -1) { 
				break;
			}
			carrito.add(precio); // Afegeix el preu introduït al carro
		}
	}

	public static double[] seleccionarIVA(Scanner sc, ArrayList<Double> carrito) {
		double suma = 0; // Inicialitza la suma del preu brut
		for (double precio : carrito) { // Bucle foreach per recòrrer l'ArrayList
			suma += precio; // Suma de tot el preu brut, es el mateix que suma = suma + precio
		}

		System.out.println("El precio en bruto es: " + (Math.round(suma * 100.0) / 100.0));
		System.out.println("\nSelecciona el IVA: \n1. 21%\n2. 4%");
		int opcionIVA = sc.nextInt(); 

		double IVA = 0; // Inicialitza l'IVA
		double totalconIVA = 0; // Inicialitza el total amb l'IVA
		switch (opcionIVA) {
		case 1:
			IVA = 0.21; // Opció del 21%
			totalconIVA = suma * (1 + IVA); // Calcula el total amb l'IVA
			System.out.println("El precio con el 21% de IVA es: " + (Math.round(totalconIVA * 100.0) / 100.0));
			break;
		case 2:
			IVA = 0.04; // Opció del 4%
			totalconIVA = suma * (1 + IVA); // Calcula el total amb l'IVA
			System.out.println("El precio con el 4% de IVA es: " + Math.round(totalconIVA * 100.0) / 100.0);
			break;
		default:
			System.out.println("Opción de IVA no válida."); // Missatge d'error si no s'introdueix cap de les opcions anteriors
			break;
		}
		return new double[] { IVA, suma, totalconIVA }; // Torna un array amb els tres valors del mètode per fer-los servir
	}

	public static void resumen(double IVA, double suma, double totalconIVA, ArrayList<Double> carrito) {
		System.out.println("\n--- Resumen de la compra ---");
		System.out.println("IVA aplicado: " + (IVA * 100) + "%"); 
		System.out.println("Precio bruto: " + (Math.round(suma * 100.0) / 100.0));
		System.out.println("Precio total (con IVA): " + (Math.round(totalconIVA * 100.0) / 100.0)); // Total con IVA
		System.out.println("Número de artículos comprados: " + carrito.size());
	}

	public static void pagoYcambio(Scanner sc, double totalconIVA) {
		System.out.println("Ingrese la cantidad pagada por el cliente: ");
		double pago = sc.nextDouble(); // Llegeix el pagament de l'usuari
		double cambio = Math.round((pago - totalconIVA) * 100.0) / 100.0; // Càlcul del canvi arrodonit
		if (cambio < 0) { // Verifica si falten diners
			System.out.println("Falta " + cambio + " por pagar.");
		} else {
			System.out.println("Cambio a devolver: " + cambio + " €"); // Canvi a tornar
		}
	}
}