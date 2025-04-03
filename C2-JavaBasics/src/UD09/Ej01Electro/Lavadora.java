package UD09.Ej01Electro;

public class Lavadora extends Electrodoméstico implements Electrodomesticable {
	protected double carga;
	protected final double CARGA = 5;

	Lavadora() {
		this.carga = CARGA;

	}

	Lavadora(double precioBase, double carga) {
		this.carga = carga;
	}

	Lavadora(double precioBase, String color, String consumo, double peso, double carga) {
		this.precioBase = precioBase;
		setColor(color);
		setConsumo(consumo);
		this.peso = peso;
		this.carga = carga;

	}

	public void mostrar() {
		System.out
				.println("La lavadora es de color " + this.color + ", cuesta " 
						+ String.format("%.2f", Math.abs(this.precioFinal())) + "€, tiene consumo "
						+ this.consumo + ", pesa " + this.peso 
						+ " kilos y soporta una carga de " + this.carga + ".");
	}

	@Override
	public double precioFinal() {
		double precioFinal = super.precioBase(this.precioBase, this.consumo, this.peso);
		{

			if (this.carga > 30) {
				precioFinal += 50;

			}

			return precioFinal;
		}
	}

	public double getCarga() {
		return carga;

	}
}
