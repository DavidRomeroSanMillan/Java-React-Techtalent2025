package UD09.Ej05Aula;

public class Aula {
	private String materia = "";
	private int numAula = 0;
	private int maxAlumno = 0;

	Aula(String materia, int numAula, int maxAlumno) {
		this.materia = materia;
		this.numAula = numAula;
		this.maxAlumno = maxAlumno;
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
