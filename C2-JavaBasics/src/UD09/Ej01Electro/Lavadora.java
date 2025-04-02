package UD09.Ej01Electro;

public class Lavadora extends Electrodoméstico {
	protected double carga;
	protected final double CARGA = 5;

	Lavadora() {
		this.carga = CARGA;

	}

	Lavadora(double precioBase, double carga) {
		this.carga = carga;
		this.precioBase = precioFinal(precioBase, this.consumo, this.peso, this.carga);
	}

	Lavadora(double precioBase, String color, String consumo, double peso, double carga) {
		this.precioBase = precioBase;
		setColor(color);
		setConsumo(consumo);
		this.peso = peso;
		this.carga = carga;
		this.precioBase = precioFinal(precioBase, this.consumo, this.peso, this.carga);
		
	}
	public void mostrar() {
		System.out.println("La lavadora es de color " + this.color + ", cuesta " 
							+ this.precioBase + ", tiene consumo "
							+ this.consumo + ", pesa " + this.peso 
							+ " kilos y soporta una carga de "+this.carga+".");
	}

	public double precioFinal(double precioBase, String consumo, double peso, double carga) {

		switch (consumo) {
		case "A" -> precioBase += 100;
		case "B" -> precioBase += 80;
		case "C" -> precioBase += 60;
		case "D" -> precioBase += 50;
		case "E" -> precioBase += 30;
		case "F" -> precioBase += 10;
		}

		if (peso > 80) {
			precioBase += 100;

		} else if (peso > 50) {
			precioBase += 80;

		} else if (peso > 20) {
			precioBase += 50;

		} else if (peso <= 19) {
			precioBase += 10;
		}
		
		if (carga > 30) {
			precioBase += 50;

		}

		return precioBase;

	}

	public double getCarga() {
		return carga;

	}
}
