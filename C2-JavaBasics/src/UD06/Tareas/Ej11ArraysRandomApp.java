package UD06.Tareas;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Ej11ArraysRandomApp {

	public static void main(String[] args) {

// Inicializamos variables
		int dimension = Integer.parseInt(JOptionPane.showInputDialog("Introduce la dimensión de los arrays: "));
		int[] array1 = new int[dimension];
		int[] array2 = new int[dimension];
		int[] array3 = new int[dimension];

// Relacionamos el array 1 con el array 2
		array1 = randomArray1(array1, dimension);
		array2 = array1;

// Imprimimos los valores de los arrays en el primer paso
		System.out.println("En el primer paso, los valores del Array 1 son: " + Arrays.toString(array1));
		System.out.println("En el primer paso, los valores del Array 2 son: " + Arrays.toString(array2) + "\n");

// Reasignamos el array2 como random
		array2 = Array2Rand(array2, dimension);

// Imprimimos los valores de los arrays en el segundo paso
		System.out.println("En el segundo paso, los valores del Array 1 son: " + Arrays.toString(array1));
		System.out.println("En el segundo paso, los valores del Array 2 son: " + Arrays.toString(array2) + "\n");

// Reasignamos el array3 del método de la multiplicación
		array3 = multiplicacionArrays(array1, array2, dimension);

// Imprimimos los valores de los arrays en el tercer paso
		System.out.println("En el tercer paso, los valores del Array 1 son: " + Arrays.toString(array1));
		System.out.println("En el tercer paso, los valores del Array 2 son: " + Arrays.toString(array2));
		System.out.println("En el tercer paso, los valores del Array 3 son: " + Arrays.toString(array3));

	}

	public static int[] randomArray1(int[] array1, int dimension) {

// Crear un método que haga que los arrays sean creados random
		array1 = new int[dimension];

		for (int i = 0; i < dimension; i++) {
			array1[i] = (int) (Math.random() * 100);
		}
		return array1;
	}

	public static int[] Array2Rand(int[] array2, int dimension) {
		int[] array2rand = new int[dimension];
		int[] random = new int[dimension];

		for (int i = 0; i < dimension; i++) {
			random[i] = (int) ((Math.random() * 5) + 1);
// Números aleatorios hasta el 5
			array2rand[i] = array2[i] * random[i];
		}

		return array2rand;
	}

	public static int[] multiplicacionArrays(int[] array1, int[] array2, int dimension) {

// Crear un método que multiplique cada posición del array1 por la misma del
// array2 y que se guarde en array3
		int[] array3 = new int[dimension];
		for (int i = 0; i < dimension; i++) {
			array3[i] = array1[i] * array2[i];
		}
		return array3;
	}
}