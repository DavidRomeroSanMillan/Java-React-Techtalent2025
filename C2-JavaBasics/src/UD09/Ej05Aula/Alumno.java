package UD09.Ej05Aula;

import java.util.Random;

public class Alumno extends Persona {

	protected int nota = 0;
	protected boolean ausencia = false;

	Alumno() {
		super();
		this.nota = notaRandom();
		this.ausencia = Math.random() < 0.5;

	}

	Alumno(String nombre, int edad, String sexo, int nota) {
		super(nombre, edad, sexo);
		this.nota = nota;
		this.ausencia = getAusencia();
	}

	public boolean getAusencia() {
		return ausencia;

	}

	public int edadRandom() {
		Random edadRandom = new Random();
		int edRand = edadRandom.nextInt(20) + 20;
		return edRand;
	}

	public String toString() {
		return "Alumno/a " + this.nombre + "{"+this.sexo+"}, tiene " + this.edad + " años, una nota de " + this.nota
				+ " y ha asistido a clase.";
	}
	public String ausenciaString() {
		return "Alumno/a " + this.nombre + "{"+this.sexo+"}, tiene " + this.edad + " años, una nota de " + this.nota
				+ " ha faltado a clase.";
	}

	public int notaRandom() {
		Random random = new Random();
		int nota = random.nextInt(11);
		return nota;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
