package UD06.Tareas;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Ej11ArraysRandomApp {

	public static void main(String[] args) {

		int dimension = Integer.parseInt(JOptionPane.showInputDialog("Escoge el tamaño de los arrays:"));

		int[] array1 = new int[dimension];
		int[] array2 = new int[dimension];
		int[] array3 = new int[dimension];

		array1 = randomArray(array1, dimension);
		array2 = array1;
		
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		
		array2 = randomArray(array2, dimension);
		
		System.out.println(Arrays.toString(array2));
		
		array3 = multiArray(array1, array2, dimension);
		
		System.out.println(Arrays.toString(array3));
	}

	public static int[] randomArray(int[] array1, int dimension) {
		int num[] = new int[dimension];
		// Declaramos un array
		for (int i = 0; i < dimension; i++) {
			num[i] = (int) (Math.random() * 100);
		}
		return num;
	}

	public static int[] multiArray(int[] array1, int[] array2, int dimension) {
		int ar3[] = new int[dimension];
		for (int i = 0; i < dimension; i++) {
			ar3[i] = array1[i] * array2[i];

		}
		return ar3;

	}
}
