package UD08;

public class Ej01Persona {

	private String nombre;
	private int edad;
	private String dni;
	private final String sexo;
	private double peso;
	private double altura;

	public Ej01Persona() {
		this.nombre = "";
		this.edad = 0;
		this.dni = "12345678A";
		this.sexo = "M";
		this.peso = 0;
		this.altura = 0.0;
	}

	public Ej01Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = "12345678A";
		this.sexo = "M";
	}

	public Ej01Persona(String nombre, int edad, String dni, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = "M";
		this.peso = peso;
		this.altura = altura;

	}

	public void mostrar() {
		System.out.println("El nombre es " + this.nombre + " y tiene " + this.edad + " años. "
							+ "Su dni es " + this.dni + ", su sexo es " + this.sexo + ", su peso es " 
							+ this.peso + " y su altura es " + this.altura + ".");
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return dni;
	}

	public void setDNI(String dni) {
		this.dni = dni;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getSexo() {
		return sexo;
	}

}