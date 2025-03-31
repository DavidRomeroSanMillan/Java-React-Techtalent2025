package UD09.Ej01Electro;

public class ElectroApp {

	public static void main(String[] args) {
			Electrodoméstico electro1 = new Electrodoméstico();
			electro1.mostrarElectro();
			
			Electrodoméstico electro2 = new Electrodoméstico(500, 150.7);
			electro2.mostrarElectro();
			
			Electrodoméstico electro3 = new Electrodoméstico(600, "negro", "B", 150.7);
			electro3.mostrarElectro();
		}

	}


