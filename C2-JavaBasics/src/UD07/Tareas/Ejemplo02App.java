package UD07.Tareas;

//Importamos las librerías necesarias
import java.util.ArrayList;
import java.util.Scanner;

public class Ejemplo02App {

//Método principal: punto de inicio del programa
	public static void main(String[] args) {
		double IVA = 0.21; // Tasa de IVA inicial
		Scanner sc = new Scanner(System.in); // Escáner para leer entradas del usuario
		ArrayList<Double> carrito = new ArrayList<>(); // Lista para almacenar los precios

//Llamada a los métodos principales
		ingresePrecios(sc, carrito); // Recopila precios de productos
		double[] resultados = seleccionarIVA(sc, carrito); // Selección de IVA y cálculo de totales
		IVA = resultados[0]; // Se actualiza el valor del IVA
		double suma = resultados[1]; // Suma de los precios sin IVA
		double totalconIVA = resultados[2]; // Total con IVA incluido
		resumen(IVA, suma, totalconIVA, carrito); // Muestra resumen de la compra
		pagoYcambio(sc, totalconIVA); // Gestiona el pago y cambio
	}

//Método para ingresar precios de los productos
	public static void ingresePrecios(Scanner sc, ArrayList<Double> carrito) {
		System.out.println("Ingrese el precio de los productos uno por uno (digite -1 para terminar):");
		while (true) {
			double precio = sc.nextDouble(); // Lee el precio ingresado
			if (precio == -1) { // Finaliza cuando el precio es -1
				break;
			}
			carrito.add(precio); // Añade el precio a la lista
		}
	}

//Método para seleccionar IVA y calcular totales
	public static double[] seleccionarIVA(Scanner sc, ArrayList<Double> carrito) {
		double suma = 0; // Inicializa la suma de los precios
		for (double precio : carrito) { // Recorre la lista de precios
			suma += precio; // Acumula los precios
		}

		System.out.println("El precio en bruto es: " + (Math.round(suma * 100.0) / 100.0));
		System.out.println("\nSelecciona el IVA: \n1. 21%\n2. 4%");
		int opcionIVA = sc.nextInt(); // Lee la opción del usuario

		double IVA = 0; // Inicializa el IVA
		double totalconIVA = 0; // Inicializa el total con IVA
		switch (opcionIVA) {
		case 1:
			IVA = 0.21; // Si elige 21% de IVA
			totalconIVA = suma * (1 + IVA); // Calcula total con IVA
			System.out.println("El precio con el 21% de IVA es: " + (Math.round(totalconIVA * 100.0) / 100.0));
			break;
		case 2:
			IVA = 0.04; // Si elige 4% de IVA
			totalconIVA = suma * (1 + IVA); // Calcula total con IVA
			System.out.println("El precio con el 4% de IVA es: " + Math.round(totalconIVA * 100.0) / 100.0);
			break;
		default:
			System.out.println("Opción de IVA no válida."); // Error si la opción no es válida
			break;
		}
		return new double[] { IVA, suma, totalconIVA }; // Retorna los valores calculados
	}

//Método para mostrar un resumen de la compra
	public static void resumen(double IVA, double suma, double totalconIVA, ArrayList<Double> carrito) {
		System.out.println("\n--- Resumen de la compra ---");
		System.out.println("IVA aplicado: " + (IVA * 100) + "%"); // Muestra el IVA aplicado
		System.out.println("Precio bruto: " + (Math.round(suma * 100.0) / 100.0)); // Precio sin IVA
		System.out.println("Precio total (con IVA): " + (Math.round(totalconIVA * 100.0) / 100.0)); // Total con IVA
		System.out.println("Número de artículos comprados: " + carrito.size()); // Número de productos
	}

//Método para gestionar el pago y calcular el cambio
	public static void pagoYcambio(Scanner sc, double totalconIVA) {
		System.out.println("Ingrese la cantidad pagada por el cliente: ");
		double pago = sc.nextDouble(); // Lee la cantidad pagada
		double cambio = Math.round((pago - totalconIVA) * 100.0) / 100.0; // Calcula el cambio redondeado
		if (cambio < 0) { // Verifica si falta dinero
			System.out.println("Falta " + cambio + " por pagar.");
		} else {
			System.out.println("Cambio a devolver: " + cambio + " €"); // Muestra el cambio a devolver
		}
	}
}