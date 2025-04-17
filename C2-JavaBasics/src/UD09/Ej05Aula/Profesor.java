package UD09.Ej05Aula;

import java.util.Random;

public class Profesor extends Persona {
	protected String materia = "";
	String[] materias = { "matemáticas", "filosofía", "física" };
	Profesor() {
		super();
		this.edad = edadRandom();
		this.materia = getMateriaRandom();
		this.ausencia = Math.random() < 0.2;
	}

	Profesor(String nombre, int edad, String sexo, String materia) {
		super(nombre, edad, sexo);
		this.materia = materia;
	}

	public boolean getAusencia() {
		return ausencia;

	}

	public String getMateriaRandom() {
		Random materiaRandom = new Random();
		int index = materiaRandom.nextInt(materias.length);
		return materias[index];
	}

	public int edadRandom() {
		edad = (int) Math.random() * 30 + 30;
		return edad;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
}
