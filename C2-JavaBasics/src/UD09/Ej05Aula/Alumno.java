package UD09.Ej05Aula;

public class Alumno extends Persona {

	private int nota = 0;

	Alumno(String nombre, int edad, String sexo, int nota) {
		super(nombre, edad, sexo);
		this.nota = nota;
	}

	public boolean novillos() {
		int novillos = (int) (Math.random() * 100);
		if (novillos > 50) {
			return true;
		} else {
			return false;
		}

	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
