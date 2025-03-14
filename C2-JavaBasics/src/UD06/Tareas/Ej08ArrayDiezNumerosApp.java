package UD06.Tareas;

import java.util.Scanner;
public class Ej08ArrayDiezNumerosApp {

	public static void main(String[] args) {

		int num[] =rellenarArray(0);
		imprimirArray(num);

	}
	
	public static int[] rellenarArray(int a) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[10];
		for (int i = 0; i < num.length; i++) {
			num[i]=Integer.parseInt(sc.nextLine());
		}
		
		return num;
	}
	
	public static void imprimirArray (int lista[]) {
		for (int i = 0; i < lista.length; i++) {System.out.println("El índice " + i 
				+ " tiene el número: "+lista[i]); 			
		}
	}
		
}