package UD07.Tareas;

import java.util.HashMap;
import java.util.Scanner;

public class EjemploEj3App {

	// Diccionario para almacenar los artículos y sus precios
	private static HashMap<String, Double> baseDatosPrecios = new HashMap<>();
	private static HashMap<String, Integer> baseDatosStock = new HashMap<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		inicializarBaseDatos();
		mostrarMenu();
	}

	// Método principal para mostrar el menú al usuario
	private static void mostrarMenu() {
		int opcion;
		do {
			System.out.println("\n===== MENU PRINCIPAL =====");
			System.out.println("1. Listar todos los productos");
			System.out.println("2. Consultar información de un producto");
			System.out.println("3. Añadir nuevo producto");
			System.out.println("4. Salir");
			System.out.print("Elige una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar buffer
			procesarOpcion(opcion);
		} while (opcion != 4);
	}

	// Método para procesar las opciones del menú
	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			listarProductos();
			break;
		case 2:
			consultarProducto();
			break;
		case 3:
			añadirProducto();
			break;
		case 4:
			System.out.println("¡Gracias por usar el sistema! Hasta pronto.");
			break;
		default:
			System.out.println("Opción no válida. Por favor, intenta de nuevo.");
		}
	}

	// Método para inicializar la base de datos con 10 artículos
	private static void inicializarBaseDatos() {
		baseDatosPrecios.put("Manzana", 0.99);
		baseDatosPrecios.put("Leche", 1.49);
		baseDatosPrecios.put("Pan", 2.75);
		baseDatosPrecios.put("Arroz", 1.20);
		baseDatosPrecios.put("Huevos", 3.50);
		baseDatosPrecios.put("Queso", 4.99);
		baseDatosPrecios.put("Tomate", 1.10);
		baseDatosPrecios.put("Pasta", 2.30);
		baseDatosPrecios.put("Café", 5.40);
		baseDatosPrecios.put("Té", 3.00);

		baseDatosStock.put("Manzana", 50);
		baseDatosStock.put("Leche", 30);
		baseDatosStock.put("Pan", 20);
		baseDatosStock.put("Arroz", 100);
		baseDatosStock.put("Huevos", 60);
		baseDatosStock.put("Queso", 15);
		baseDatosStock.put("Tomate", 40);
		baseDatosStock.put("Pasta", 70);
		baseDatosStock.put("Café", 25);
		baseDatosStock.put("Té", 45);
	}

	// Método para listar todos los productos
	private static void listarProductos() {
		System.out.println("\n===== LISTA DE PRODUCTOS =====");
		for (String articulo : baseDatosPrecios.keySet()) {
			double precio = baseDatosPrecios.get(articulo);
			int stock = baseDatosStock.get(articulo);
			System.out.println("Artículo: " + articulo + ", Precio: " + precio + "€, Stock: " + stock);
		}
	}

	// Método para consultar información de un producto
	private static void consultarProducto() {
		System.out.print("\nIntroduce el nombre del artículo: ");
		String articulo = scanner.nextLine();
		if (baseDatosPrecios.containsKey(articulo)) {
			double precio = baseDatosPrecios.get(articulo);
			int stock = baseDatosStock.get(articulo);
			System.out.println("Artículo: " + articulo + ", Precio: " + precio + "€, Stock: " + stock);
		} else {
			System.out.println("El artículo no se encuentra en la base de datos.");
		}
	}

	// Método para añadir un nuevo producto
	private static void añadirProducto() {
		System.out.print("\nIntroduce el nombre del nuevo artículo: ");
		String articulo = scanner.nextLine();
		if (baseDatosPrecios.containsKey(articulo)) {
			System.out.println("El artículo ya existe. Puedes actualizarlo manualmente.");
		} else {
			System.out.print("Introduce el precio del artículo: ");
			double precio = scanner.nextDouble();
			System.out.print("Introduce la cantidad en stock: ");
			int stock = scanner.nextInt();
			scanner.nextLine(); // Limpiar buffer
			baseDatosPrecios.put(articulo, precio);
			baseDatosStock.put(articulo, stock);
			System.out.println("Artículo añadido correctamente.");
		}
	}
}