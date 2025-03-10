package UD06.Tareas;

import java.util.Scanner;
public class Ej08ArrayDiezNumeros {

	public static void main(String[] args) {

		int num[] =rellenarArrayDesde(5);
		imprimirArray(num);

	}
	
	public static int[] rellenarArrayDesde(int a) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[10];
		for (int i = 0; i < num.length; i++) {
			num[i]=Integer.parseInt(sc.nextLine());
		}
		
		return num;
	}
	
	public static void imprimirArray (int lista[]) {
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
	}
		
}