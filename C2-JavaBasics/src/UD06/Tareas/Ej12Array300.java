package UD06.Tareas;

import javax.swing.JOptionPane;

public class Ej12Array300 {
	//Debemos coger el input del usuario, y en un bucle filtrar los números del array random para que,
	//en otro array, se pongan los que son múltiplos de 5.
	
	
	public static void main(String[] args) {
		int dimension = Integer.parseInt(JOptionPane.showInputDialog("Introduce el último valor que quieres: "));
		
            
		
	}
	 public static int[] randomArray1(int[] array1, int dimension) {

	        // Crear un método que haga que los arrays sean creados random
	        array1 = new int[dimension];
	        if (dimension <= 0) {
	            System.out.println("El tamaño del array debe ser mayor que 0.");}
	        else {
	        for (int i = 0; i < dimension; i++) {
	            array1[i] = (int) (Math.random() * 300) + 1;
	        }
	        
	    }return array1;}
	 
	 public static int[] comparador(int[] array1, int numero) {
	        
	            }
	        }
			return array1;
	 }
}