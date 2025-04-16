package UD09.Ej05Aula;

import java.util.Random;

public class Aula {
	protected String materia = "";
	String[] materias = { "matemáticas", "filosofía", "física" };
	protected int numAula = 0;
	protected int maxAlumno = 0;

	Aula() {
		this.materia = getMateriaRandom();
		this.numAula = getNumAulaRandom();
		this.maxAlumno = getMaxAulmnoRandom();
	}

	Aula(String materia, int numAula, int maxAlumno) {
		this.materia = materia;
		this.numAula = numAula;
		this.maxAlumno = maxAlumno;
	}

	public String getMateriaRandom() {
		Random materiaRandom = new Random();
		int index = materiaRandom.nextInt(materias.length);
		return materias[index];
	}

	public int getNumAulaRandom() {
		Random numAulaRandom = new Random();
		int aulaRand = numAulaRandom.nextInt(5);
		return aulaRand;
	}

	public int getMaxAulmnoRandom() {
		Random maxAlumnoRandom = new Random();
		int alumnoRand = maxAlumnoRandom.nextInt(10) + 10;
		return alumnoRand;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public int getNumAula() {
		return numAula;
	}

	public void setNumAula(int numAula) {
		this.numAula = numAula;
	}

	public int getMaxAlumno() {
		return maxAlumno;
	}

	public void setMaxAlumno(int maxAlumno) {
		this.maxAlumno = maxAlumno;
	}

}
