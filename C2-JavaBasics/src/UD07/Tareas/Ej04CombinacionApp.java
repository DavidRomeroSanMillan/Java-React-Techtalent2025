package UD07.Tareas;

import javax.swing.*;
import java.util.*;

public class Ej04CombinacionApp {
	private static final Scanner scanner = new Scanner(System.in);
	private static final HashMap<String, HashMap<String, Double>> inventario = new HashMap<>();
	private static final ArrayList<Double> carrito = new ArrayList<>();

	public static void main(String[] args) {
		inicializarInventario();
		elegirModo();
	}

	// Menú per escollir entre usuari i administrador
	private static void elegirModo() {
		String[] opciones = { "Administrador", "Usuario", "Salir" };
		int opcion = JOptionPane.showOptionDialog(null, "Selecciona el modo de acceso:", "Modo de acceso",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

		switch (opcion) {
		case 0 -> mostrarMenuStock();
		case 1 -> mostrarMenuCompras();
		case 2 -> System.exit(0);
		}
	}

	// Inicialitza la llista de productes amb inventari preus
	private static void inicializarInventario() {
		agregarProducto("Manzana", 0.99, 50);
		agregarProducto("Leche", 1.49, 30);
		agregarProducto("Pan", 2.75, 20);
		agregarProducto("Arroz", 1.20, 100);
		agregarProducto("Huevos", 3.50, 60);
	}

	// Menú administrador amb scanner
	private static void mostrarMenuStock() {
		int opcion;
		do {
			System.out.println("\n===== MODO ADMINISTRADOR: GESTIÓN DE STOCK =====");
			System.out.println("1. Listar productos");
			System.out.println("2. Consultar un producto");
			System.out.println("3. Añadir o actualizar producto");
			System.out.println("4. Volver al menú principal");
			System.out.print("Elige una opción: ");
			opcion = solicitarEntero();

			switch (opcion) {
			case 1 -> listarProductos();
			case 2 -> consultarProducto();
			case 3 -> añadirOActualizarProducto();
			case 4 -> elegirModo(); // Això torna al menú principal
			default -> System.out.println("Opción no válida.");
			}
		} while (opcion != 4);
	}

	// Menú de compres amb JOptionPane
	private static void mostrarMenuCompras() {
		String[] opciones = { "Agregar producto al carrito", "Finalizar compra", "Volver al menú principal" };
		boolean seguirComprando = true;

		while (seguirComprando) {
			int opcion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Modo Usuario: Compras",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

			switch (opcion) {
			case 0 -> venderProducto();
			case 1 -> finalizarCompra();
			case 2 -> {
				JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
				seguirComprando = false;
				elegirModo(); // Volver al menú principal
			}
			}
		}
	}

	// Afegeix un producte a l'inventari
	private static void agregarProducto(String nombre, double precio, int stock) {
		HashMap<String, Double> info = new HashMap<>();
		info.put("precio", precio);
		info.put("stock", (double) stock);
		inventario.put(nombre.toLowerCase(), info);
	}

	// Llista dels productes disponibles
	private static void listarProductos() {
		System.out.println("\n===== LISTA DE PRODUCTOS =====");
		inventario.forEach((producto, info) -> {
			System.out.println(
					producto + " → Precio: " + info.get("precio") + "€, Stock: " + info.get("stock").intValue());
		});
	}

	// Consulta un producte a l'inventari
	private static void consultarProducto() {
		System.out.print("\nIntroduce el nombre del artículo: ");
		String articulo = scanner.nextLine().toLowerCase();
		if (inventario.containsKey(articulo)) {
			System.out.println("Producto: " + articulo + ", Precio: " + inventario.get(articulo).get("precio")
					+ "€, Stock: " + inventario.get(articulo).get("stock").intValue());
		} else {
			System.out.println("El artículo no está en la base de datos.");
		}
	}

	// Afegeix/actualitza un producte a l'inventari
	private static void añadirOActualizarProducto() {
		System.out.print("\nIntroduce el nombre del artículo: ");
		String articulo = scanner.nextLine().toLowerCase();

		if (inventario.containsKey(articulo)) {
			System.out.println("El artículo ya existe en el inventario.");
			System.out.print("Introduce la cantidad adicional en stock: ");
			int cantidadExtra = solicitarEntero();
			inventario.get(articulo).put("stock", inventario.get(articulo).get("stock") + cantidadExtra);
			System.out.println("Stock actualizado correctamente.");
		} else {
			System.out.print("Introduce el precio del artículo: ");
			double precio = solicitarDouble();
			System.out.print("Introduce la cantidad en stock: ");
			int stock = solicitarEntero();
			agregarProducto(articulo, precio, stock);
			System.out.println("Artículo añadido correctamente.");
		}
	}

	// Permet vendre productes (JoptionPane) i reduir el stock
	private static void venderProducto() {
		String producto = JOptionPane.showInputDialog("Introduce el nombre del producto:").toLowerCase();
		if (inventario.containsKey(producto)) {
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad:"));
			if (cantidad <= inventario.get(producto).get("stock")) {
				double precioTotal = inventario.get(producto).get("precio") * cantidad;
				carrito.add(precioTotal);
				inventario.get(producto).put("stock", inventario.get(producto).get("stock") - cantidad);
				JOptionPane.showMessageDialog(null, "Producto agregado al carrito.");
			} else {
				JOptionPane.showMessageDialog(null, "Stock insuficiente.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Producto no disponible.");
		}
	}

	// Calcula el total de la compra i finalitza la venta
	private static void finalizarCompra() {
		if (carrito.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay productos en el carrito.");
			return;
		}

		double suma = 0;
		for (double precio : carrito) {
			suma += precio;
		} // Intentar hacer un foreach en vez de un stream de datos
		String[] opcionesIVA = { "21%", "4%" };
		int opcionIVA = JOptionPane.showOptionDialog(null, "Selecciona el IVA:", // Rectificar ternario del IVA
				"IVA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesIVA, opcionesIVA[0]);

		double IVA = opcionIVA == 0 ? 0.21 : 0.04;
		double totalConIVA = suma * (1 + IVA);

		double pago = Double.parseDouble(
				JOptionPane.showInputDialog("Total: " + String.format("%.2f", totalConIVA) + "€. Introduce el pago:"));
		double cambio = pago - totalConIVA;

		if (cambio < 0) {
			JOptionPane.showMessageDialog(null, "Faltan " + String.format("%.2f", Math.abs(cambio)) + "€ por pagar.");
		} else {
			JOptionPane.showMessageDialog(null, "Cambio a devolver: " + String.format("%.2f", cambio) + "€");
			carrito.clear();
		}
	}

	// Mètodes auxiliars d'error d'input d'usuari
	private static int solicitarEntero() {
		while (!scanner.hasNextInt()) {// mentres scanner NO TINGUI un Int:
			System.out.print("Error. Introduce un número válido: ");
			scanner.next();
		}
		int valor = scanner.nextInt();
		scanner.nextLine();
		return valor;
	}

	private static double solicitarDouble() {
		while (!scanner.hasNextDouble()) {// mentres scanner NO TINGUI un Double:
			System.out.print("Error. Introduce un número válido: ");
			scanner.next();
		}
		double valor = scanner.nextDouble();
		scanner.nextLine();
		return valor;
	}
}