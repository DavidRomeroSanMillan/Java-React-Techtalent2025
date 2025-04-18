package UD09.Ej04Ecuación;

public class Raices {
	private double a = 0;
	private double b = 0;
	private double c = 0;

	Raices(double a, double b, double c) {
		if (a == 0) {
			throw new IllegalArgumentException("El valor de 'a' no puede ser 0");
		}
		this.a = a;
		this.b = b;
		this.c = c;
	}

	private double getDiscriminante() {
		double discriminante = (Math.pow(this.b, 2)) - 4 * this.a * this.c;

		return discriminante;

	}

	private boolean tieneRaices() {
		return getDiscriminante() > 0;

	}

	private boolean tieneRaiz() {
		return getDiscriminante() == 0;
	}

	public void calcular() {
		if (tieneRaices()) {
			obtenerRaices();
		} else if (tieneRaiz()) {
			obtenerRaiz();
		} else {
			System.out.println("No tiene raíces.");

		}

	}

	private void obtenerRaices() {
		double discriminante = getDiscriminante();
		double calculoMenos = (-this.b - Math.sqrt(discriminante)) / (2 * this.a);
		double calculoMas = (-this.b + Math.sqrt(discriminante)) / (2 * this.a);
		System.out.println("Las posibles soluciones son: " + calculoMenos + " y " + calculoMas + ".");
	}

	private void obtenerRaiz() {

		double unicaSolucion = -this.b / (2 * this.a);
		System.out.println("La única solución es: " + unicaSolucion + ".");
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

}
