package UD09.Ej01Electro;

public class ElectroApp {

	public static void main(String[] args) {

		Lavadora Siemens = new Lavadora(150, 25);
		Lavadora Balay = new Lavadora(200, 20);
		Lavadora Fagor = new Lavadora(500.0, "rojo", "C", 200.0, 30.0);
		Lavadora Micro = new Lavadora(600.0, "azul", "A", 150.0, 35.0);
		Lavadora Megamax = new Lavadora(850.0, "negro", "E", 250.0, 50.0);

		Televisor Sony = new Televisor(100, 20);
		Televisor Huawei = new Televisor(150, 25);
		Televisor HP = new Televisor(250, "negro", "B", 25, 50, true);
		Televisor HP101 = new Televisor(500, "blanco", "D", 15, 60, true);
		Televisor Miramax = new Televisor(1300, "blanco", "A", 300, 300, false);

		Electrodoméstico electro[] = { Siemens, Balay, Fagor, Sony, Huawei, 
										HP, Micro, HP101, Megamax, Miramax };
		double totalTelevisor = 0;
		double totalLavadora = 0;

		for (Electrodoméstico e : electro) {
			if (e instanceof Televisor) {
				totalTelevisor += e.precioFinal();
			}
			if (e instanceof Lavadora) {
				totalLavadora += e.precioFinal();
			}
			e.mostrar();
		}
		System.out.println("El precio total de los televisores es: " + String.format("%.2f", Math.abs(totalTelevisor)) + "€.");
		System.out.println("El precio total de las lavadoras es: " + String.format("%.2f", Math.abs(totalLavadora)) + "€.");
		double totalFinal = totalTelevisor + totalLavadora;
		System.out.println("El precio total de todos los electrodomésticos es: " + String.format("%.2f", Math.abs(totalFinal)) + "€.");

	}

}
