package UD06.Tareas;

import java.util.Arrays;
import java.util.Scanner;

public class Ej10ArrayPrimoRandomApp {

	public static void main(String[] args) {
		System.out.println("Introduce el tamaño del array: ");
		Scanner sc = new Scanner(System.in);
		int tamaño = Integer.parseInt(sc.nextLine());
		int array[] = rellenarArray(tamaño);
		imprimirArray(array);
		System.out.println("El número más alto es: " + findLargestNumber(array));
		sc.close();
	}

	public static int[] rellenarArray(int tamaño) {
		int num[] = new int[tamaño];
		Scanner minmax = new Scanner(System.in);
		System.out.println(("Introduce el número máximo del array: "));
		int max = minmax.nextInt();
		System.out.println(("Introduce el número mínimo del array: "));
		int min = minmax.nextInt();
		for (int i = 0; i < num.length; i++) {
			int random = (int) ((Math.random() * (max - min + 1) + min));
			if (esPrimo(random)) {
				num[i] = (int) random;
			} else {
				i--;
			}
		}

		return num;
	}

	public static boolean esPrimo(int numero) {
		boolean esPrimo = true;
		if (numero <= 1) {
			return false;
		}
		for (int a = 2; a < numero; a++) {
			if (numero % a == 0) {
				esPrimo = false;
				break;
			}
		}
		return esPrimo;

	}

	public static void imprimirArray(int lista[]) {
		for (int i = 0; i < lista.length; i++) {
			System.out.println("El índice " + i + " tiene el número: " + lista[i]);
		}
		System.out.println(Arrays.toString(lista));

	}

	public static int findLargestNumber(int[] array) {
		int max = array[0];
		for (int num : array) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}
}
