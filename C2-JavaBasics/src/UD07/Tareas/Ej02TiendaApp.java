package UD07.Tareas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ej02TiendaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Double> productos = new HashMap<>();
        ArrayList<Double> carrito = new ArrayList<>();

        inicializarProductos(productos);
        solicitarPrecios(sc, productos, carrito);
        calcularTotal(sc, carrito);

        sc.close();
    }

    public static void inicializarProductos(HashMap<String, Double> productos) {
        productos.put("manzana", 1.20);
        productos.put("leche", 0.99);
        productos.put("pan", 1.50);
    }

    public static void solicitarPrecios(Scanner sc, HashMap<String, Double> productos, ArrayList<Double> carrito) {
        System.out.println("----------PANEL PRINCIPAL COMPRA\nIntroduce el producto comprado (o 'fin' para terminar):");
        while (true) {
            String producto = sc.nextLine().toLowerCase();
            if (producto.equalsIgnoreCase("fin")) break;
            if (productos.containsKey(producto)) {
                carrito.add(productos.get(producto));
                System.out.println(productos.get(producto)+ " añadido"); // "pan añadido"
            } else {
                System.out.println("Producto no encontrado.");
            }
        }
    }

    public static void calcularTotal(Scanner sc, ArrayList<Double> carrito) {
        double total = carrito.stream().mapToDouble(Double::doubleValue).sum(); //foreach
        System.out.print("Introduce el IVA aplicado (21 o 4): ");
        double iva = sc.nextInt() == 21 ? 0.21 : 0.04;
        double totalConIVA = total + (total * iva);

        System.out.println("Total bruto: " + total);
        System.out.println("IVA aplicado: " + (iva * 100) + "%");
        System.out.println("Total con IVA: " + totalConIVA);

        System.out.print("Introduce la cantidad pagada: ");
        double pago = sc.nextDouble();
        System.out.println("Cambio a devolver: " + (pago - totalConIVA)); //redondeo del total y mostrar cantidades
    }
}