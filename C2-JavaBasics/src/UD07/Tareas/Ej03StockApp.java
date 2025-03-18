package UD07.Tareas;

import java.util.HashMap;
import java.util.Scanner;

public class Ej03StockApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> inventario = inicializarInventario();

        gestionarInventario(sc, inventario);
        sc.close();
    }

    public static HashMap<String, Integer> inicializarInventario() {
        HashMap<String, Integer> inventario = new HashMap<>();
        inventario.put("Manzanas", 50);
        inventario.put("Leche", 30);
        inventario.put("Pan", 20);
        return inventario;
    }

    public static void gestionarInventario(Scanner sc, HashMap<String, Integer> inventario) {
        int opcion;
        do {
            System.out.println("\n1. Agregar artículo\n2. Consultar stock\n3. Mostrar inventario\n4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> agregarArticulo(sc, inventario);
                case 2 -> consultarStock(sc, inventario);
                case 3 -> mostrarInventario(inventario);
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    public static void agregarArticulo(Scanner sc, HashMap<String, Integer> inventario) {
        System.out.print("Introduce el nombre del artículo: ");
        String articulo = sc.nextLine();
        System.out.print("Introduce la cantidad: ");
        int cantidad = sc.nextInt();
        inventario.put(articulo, inventario.getOrDefault(articulo, 0) + cantidad);
        System.out.println("Artículo agregado correctamente.");
    }

    public static void consultarStock(Scanner sc, HashMap<String, Integer> inventario) {
        System.out.print("Introduce el nombre del artículo: ");
        String articulo = sc.nextLine();
        System.out.println("Stock de " + articulo + ": " + inventario.getOrDefault(articulo, 0));
    }

    public static void mostrarInventario(HashMap<String, Integer> inventario) {
        System.out.println("Inventario:");
        for (String key : inventario.keySet()) {
            System.out.println(key + " → " + inventario.get(key));
        }
    }
}