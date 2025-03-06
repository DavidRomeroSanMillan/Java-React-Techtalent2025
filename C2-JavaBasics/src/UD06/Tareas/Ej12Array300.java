package UD06.Tareas;

import javax.swing.JOptionPane;

public class Ej12Array300 {
//Debemos coger el input del usuario, y en un bucle filtrar los números del array random para que,
	//en otro array, se pongan los que son múltiplos de 5.
	public static void main(String[] args) {

		
		
	}
	 public static int[] randomArray1(int[] array1, int dimension) {

	        // Crear un método que haga que los arrays sean creados random
	        array1 = new int[dimension];

	        for (int i = 0; i < dimension; i++) {
	            array1[i] = (int) (Math.random() * 300) + 1;
	        }
	        return array1;
	    }
	public static int [] comparador() {
	    int ultimoNumero = Integer.parseInt(JOptionPane.showInputDialog("Introduce el último valor que quieres: "));
		
	    
		return null;
		
	}
}