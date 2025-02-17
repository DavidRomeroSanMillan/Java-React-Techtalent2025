package UD5;
import java.util.Scanner;

public class Ejercicio3App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String welcome = "Bienvenido ";
		
		String name = sc.nextLine();
		sc.close();
		
		System.out.println(welcome + name);

	}

}
