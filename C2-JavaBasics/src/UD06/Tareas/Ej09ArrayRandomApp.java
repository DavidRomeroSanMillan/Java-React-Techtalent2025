package UD06.Tareas;

import java.util.Scanner;

public class Ej09ArrayRandomApp {

	public static void main(String[] args) {
		System.out.println("Introduce el tamaño del array: ");
		Scanner sc=new Scanner(System.in);
		int tamaño= Integer.parseInt(sc.nextLine());
		int lista[]= rellenarArray(tamaño);
		imprimirArray(lista);
		
		
	}
	public static int[] rellenarArray(int tamaño) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[tamaño];
		for (int i = 0; i < num.length; i++) {
			num[i]=(int) ((Math.random() * 10));
		}
		
		return num;
	}
	public static void imprimirArray (int lista[]) {
		int suma = 0;
		for (int i = 0; i < lista.length; i++) {System.out.println("El índice " + i 
				+ " tiene el número: "+lista[i]);
			suma = suma + lista[i];
		
		}
		System.out.println("La suma de todos los números del array es "+suma);
		
	}
}
