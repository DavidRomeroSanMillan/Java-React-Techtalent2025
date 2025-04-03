package UD09.Ej01Electro;

public class Televisor extends Electrodoméstico {

	protected double resolucion;
	protected final double RESOLUCION = 20;
	protected boolean tdt;
	protected final boolean TDT = false;

	Televisor(){
		super();
        this.resolucion = 20;
        this.tdt = false;
        this.precioBase = precioFinal(super.precioBase, this.consumo, this.peso, this.resolucion, this.tdt);
    }
	Televisor(double precioBase, double peso){
		super(precioBase, peso);
        this.resolucion = 20;
        this.tdt = false;
        this.precioBase = precioFinal(super.precioBase, this.consumo, this.peso, this.resolucion, this.tdt);
    }
	Televisor(double precioBase, String color, String consumo, double peso, double resolucion, boolean tdt){
		  super(precioBase, color, consumo, peso);
	      this.resolucion = resolucion;
	      this.tdt = tdt;
	      this.precioBase = precioFinal(super.precioBase, this.consumo, this.peso, this.resolucion, this.tdt);
	    }
	public void mostrar() {
		String tdt="";
		if (this.tdt) {tdt="tiene tdt";
			
		}else{tdt="no tiene tdt";
			
		}
		System.out.println("El televisor es de color " + this.color + ", cuesta " 
							+ this.precioBase + ", tiene consumo "
							+ this.consumo + ", pesa " + this.peso 
							+ " kilos, "+tdt+" y la pantalla es de "+this.resolucion+".");
	}
	public double precioFinal(double precioBase, String consumo, double peso, double resolucion, boolean tdt) {
		double extraResolucion= precioBase * 0.3;
		
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

		if (tdt) {
			precioBase += 50;
		}
		if (resolucion > 40) {
			precioBase += extraResolucion;
		}
		return precioBase;

	}
	public boolean getTdt() {
		return tdt;
	}
	public double getResolucion() {
		return resolucion;
	}
}
