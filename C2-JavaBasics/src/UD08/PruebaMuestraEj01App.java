package UD08;

public class PruebaMuestraEj01App {

	public static void main(String[] args) {
		Ej01Persona persona1=new Ej01Persona();
		persona1.mostrar();
		Ej01Persona persona2=new Ej01Persona("Pepe", 35, "M");
		persona2.mostrar();
		Ej01Persona persona3=new Ej01Persona("Paco", 55, "33221145C", "F", 89.4, 1.80);
		persona3.mostrar();
	}

}
