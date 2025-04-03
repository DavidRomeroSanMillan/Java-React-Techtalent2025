package UD09.Ej01Electro;

public class Televisor extends Electrodoméstico implements Electrodomesticable {

	protected double resolucion;
	protected final double RESOLUCION = 20;
	protected boolean tdt;
	protected final boolean TDT = false;

	Televisor() {
		super();
		this.resolucion = RESOLUCION;
		this.tdt = TDT;
	}

	Televisor(double precioBase, double peso) {
		super(precioBase, peso);
		this.resolucion = RESOLUCION;
		this.tdt = TDT;
	}

	Televisor(double precioBase, String color, String consumo, 
			double peso, double resolucion, boolean tdt) {
		super(precioBase, color, consumo, peso);
		this.resolucion = resolucion;
		this.tdt = tdt;
	}

	public void mostrar() {
		String tdt = "";
		if (this.tdt) {
			tdt = "tiene tdt";

		} else {
			tdt = "no tiene tdt";

		}
		System.out.println("El televisor es de color " + this.color + ", cuesta " 
				+ String.format("%.2f", Math.abs(this.precioFinal()))
				+ "€, tiene consumo " + this.consumo + ", pesa " + this.peso + " kilos, " 
				+ tdt + " y la pantalla es de "+ this.resolucion + ".");
	}

	@Override
	public double precioFinal() {
		double extraResolucion = this.precioBase * 0.3;

		double precioFinal = super.precioBase(this.precioBase, this.consumo, this.peso);
		{
			if (tdt) {
				precioFinal += 50;
			}
			if (resolucion > 40) {
				precioFinal += extraResolucion;
			}
			return precioFinal;
		}
	}

	public boolean getTdt() {
		return tdt;
	}

	public double getResolucion() {
		return resolucion;
	}
}
