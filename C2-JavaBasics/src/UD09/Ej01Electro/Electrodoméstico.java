package UD09.Ej01Electro;

public abstract class Electrodoméstico implements Electrodomesticable{
	protected double precioBase;
	protected String color;
	protected String consumo;
	protected double peso;

	protected static final double PRECIO_BASE = 100;
	protected static final String COLOR = "blanco";
	protected static final String CONSUMO = "F";
	protected static final double PESO = 5.0;

	protected static final String[] COLORES_PERMITIDOS = { "blanco", "negro", 
														"rojo", "azul", "gris" };
	protected static final String[] CONSUMO_PERMITIDO = { "A", "B", "C", "D", 
														"E", "F" };

	Electrodoméstico() {
		this.precioBase = PRECIO_BASE;
		this.color = COLOR;
		this.consumo = CONSUMO;
		this.peso = PESO;
	}

	Electrodoméstico(double precioBase, double peso) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.color = COLOR;
		this.consumo = CONSUMO;
	}

	Electrodoméstico(double precioBase, String color, String consumo, 
					double peso) {
		this.precioBase = precioBase;
		setColor(color);
		setConsumo(consumo);
		this.peso = peso;
		

	}

	public void mostrar() {
		System.out.println("El electrodoméstico es " + this.color + ", cuesta " 
							+ this.precioBase + ", tiene consumo "
							+ this.consumo + " y pesa " + this.peso + " kilos.");
	}

	protected double precioBase(double precioBase, String consumo, 
										double peso) {

		switch (consumo) {
		case "A" -> precioBase+=100;
		case "B" -> precioBase+=80;
		case "C" -> precioBase+=60;
		case "D" -> precioBase+=50;
		case "E" -> precioBase+=30;
		case "F" -> precioBase+=10;
		}
		
		
		if (peso > 80) {
			precioBase +=100;

		} else if (peso >= 50) {
			precioBase +=80;

		} else if (peso >= 20) {
			precioBase +=50;
			
		} else if (peso < 20) {
			precioBase +=10;
		}

		return precioBase;

	}

	public void setColor(String color) {
		boolean colorValido = false;
		for (String c : COLORES_PERMITIDOS) {
			if (c.equalsIgnoreCase(color)) {
				colorValido = true;
				break;
			}
		}
		if (colorValido) {
			this.color = color;
		} else {
			this.color = COLOR;
		}
	}

	public String getColor() {
		return color;
	}

	public void setConsumo(String consumo) {
		boolean consumoValido = false;
		for (String c : CONSUMO_PERMITIDO) {
			if (c.equalsIgnoreCase(consumo)) {
				consumoValido = true;
				break;
			}
		}
		if (consumoValido) {
			this.consumo = consumo;
		} else {
			this.consumo = CONSUMO;
		}
	}

	public String getConsumo() {
		return consumo;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}
}
