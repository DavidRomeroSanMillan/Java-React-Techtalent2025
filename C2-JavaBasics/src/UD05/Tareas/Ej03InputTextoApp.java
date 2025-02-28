package UD05.Tareas;
import java.util.Scanner;

public class Ej03InputTextoApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String welcome = "Bienvenido ";
		
		String name = sc.nextLine();
		sc.close();
		
		System.out.println(welcome + name);

	}

}
