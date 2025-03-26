package UD08;

public class PruebaMuestraEj03App {

	public static void main(String[] args) {
			Ej03Electro electro1 = new Ej03Electro();
			electro1.mostrarElectro();
			
			Ej03Electro electro2 = new Ej03Electro(500, 150.7);
			electro2.mostrarElectro();
			
			Ej03Electro electro3 = new Ej03Electro(600, "negro", "B", 150.7);
			electro3.mostrarElectro();
		}

	}


