package UD07.Tareas;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej01MediaAlumnosApp {

	public static void main(String[] args) {
		// Crear un método que sirva para añadir alumnos en un arraylist, y otro método
		// que sirva para meter
		// las notas de estos alumnos en otro arraylist. Estos métodos se irán
		// repitiendo hasta 3 veces (por probar)
		// y habrá otro método que calcule las medias de los números y las ponga en otro
		// arraylist.
		// Podría usar el método get para el cálculo de la media
		// Usar Scanner, no JOptionPane, será más sencillo de verlo todo a la vez
		// Recuerda que existe el foreach por favor. Mirar el método iterator
		// Quizás mirar hashmaps para ver como de viable seria

		ArrayList<String> alumnos = new ArrayList<>();
		ArrayList<Double> notas = new ArrayList<>();
		ArrayList<Double> notas0 = new ArrayList<>();
		ArrayList<Double> notas1 = new ArrayList<>();
		ArrayList<Double> notas2 = new ArrayList<>();
		ArrayList<Double> medias = new ArrayList<>();

		afegirAlumne(alumnos);

		System.out.println("Los alumnos son: " + alumnos);
		System.out.println("Añade las notas de " + alumnos.get(0));
		afegirNota0(notas0);
		System.out.println("Añade las notas de " + alumnos.get(1));
		afegirNota0(notas1);
		System.out.println("Añade las notas de " + alumnos.get(2));
		afegirNota0(notas2);

		notas.addAll(notas0);
		notas.addAll(notas1);
		notas.addAll(notas2);
		System.out.println(notas0);
		System.out.println(notas1);
		System.out.println(notas2);

		medias.add(medias(notas0));
		medias.add(medias(notas1));
		medias.add(medias(notas2));

		System.out.println("La media de " + alumnos.get(0) + " es de: "
		+medias.get(0));
		System.out.println("La media de " + alumnos.get(1) + " es de: "
		+medias.get(1));
		System.out.println("La media de " + alumnos.get(2) + " es de: "
		+medias.get(2));
		
	System.out.println("Las medias son: "+medias);
	}

	public static ArrayList<String> afegirAlumne(ArrayList<String> alumnos) {
		Scanner scanAlumne = new Scanner(System.in);
		do {
			System.out.println("Añade un alumno: ");
			alumnos.add(scanAlumne.nextLine());
		} while (alumnos.size() <= 2);
		return alumnos;

	}

//	private static ArrayList<String> imprimirAlumnos(ArrayList<String> alumnos) {
//		for (String alumno : alumnos) {
//		}
//		return alumnos;

//	}
	public static ArrayList<Double> afegirNota0(ArrayList<Double> notas0) {
		Scanner scanNota = new Scanner(System.in);

		do {
			notas0.add(Double.parseDouble(scanNota.nextLine()));
		} while (notas0.size() <= 2);

		return notas0;
	}

	public static double medias(ArrayList<Double> notas) {
		double media = (notas.get(0) + notas.get(1) + notas.get(2)) / 3;
		return media;
	}
}