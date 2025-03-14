package UD06.Tareas;

import java.util.Scanner;

public class Ej10ArrayPrimoRandomApp {

	public static void main(String[] args) {
		System.out.println("Introduce el tamaño del array: ");
		Scanner sc=new Scanner(System.in);
		int tamaño= Integer.parseInt(sc.nextLine());
		int array[]= rellenarArray(tamaño);
		imprimirArray(array);
		System.out.println("El número más alto es: "+findLargestNumber(array));
	}
	public static int[] rellenarArray(int tamaño) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[tamaño];
		for (int i = 0; i < num.length; i++) {
			int random=(int) ((Math.random() * 1001));
			if (esPrimo(random)) {num[i]= (int) random;}else {i--;}
		}
		
		return num;
	}
	public static boolean esPrimo(int numero) {
		boolean esPrimo = true;
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				esPrimo = false;
				break;
			}
		}
		return esPrimo;
	
}
	public static void imprimirArray (int lista[]) {
		for (int i = 0; i < lista.length; i++) {System.out.println("El índice " + i 
				+ " tiene el número: "+lista[i]);
		}
		
	}
	public static int findLargestNumber(int[] array) {
        int max = array[0]; // Assume the first element is the largest initially
        for (int num : array) {
            if (num > max) {
                max = num; // Update max if current number is greater
            }
        }
        return max;
    }
}
