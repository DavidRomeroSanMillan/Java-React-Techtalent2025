package UD09.Ej05Aula;

import java.util.ArrayList;
import java.util.List;

public class ClaseApp {

	public static void main(String[] args) {
		Aula Primera = new Aula();
		List<Alumno> alumnos = new ArrayList<>();
		List<Alumno> ausencias = new ArrayList<>();
		System.out.println("El aula es de " + Primera.materia + ", es la número " + Primera.numAula
				+ " y tiene una capacidad máxima de " + Primera.maxAlumno + " alumnos.");
		for (int i = 0; i < Primera.maxAlumno; i++) {
			Alumno alumno = new Alumno();
			if (!alumno.getAusencia()) {
				alumnos.add(alumno);
			} else if (alumno.getAusencia()) {
				ausencias.add(alumno);
			}
		}

		for (Alumno alumno : alumnos) {
			System.out.println(alumno);
		}
		for (Alumno alumno : ausencias) {
			System.out.println(alumno.ausenciaString());
		}

		Profesor profesor = new Profesor();
		if (alumnos.size() >= Primera.maxAlumno / 2 
				&& !profesor.getAusencia() && profesor.materia == Primera.materia) {

			System.out.println("Se ha podido hacer la clase.");
			for (Alumno alumno : alumnos) {
				if (alumno.getSexo().equals("M") && alumno.getNota() >= 5) {
					System.out.println(alumno.nombre + " está aprobado.");
				} else if (alumno.getSexo().equals("F") && alumno.getNota() >= 5) {
					System.out.println(alumno.nombre + " está aprobada.");
				}
			}

		} else {
			if (alumnos.size() < Primera.maxAlumno / 2) {
				System.out.println("No hay suficientes alumnos/as presentes.");
			}
			if (profesor.getAusencia()) {
				System.out.println("El/la profesor/a " + profesor.getNombre() + " se ha ausentado.");
			}
			if (profesor.materia != Primera.materia) {
				System.out.println("La materia del/la profesor/a no corresponde con el aula.");
			}
		}

	}
}
