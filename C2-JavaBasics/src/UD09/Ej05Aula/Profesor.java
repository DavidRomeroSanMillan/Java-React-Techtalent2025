package UD09.Ej05Aula;

public class Profesor extends Persona{
private String materia = "";


Profesor(String nombre, int edad, String sexo, String materia){
	super(nombre, edad, sexo);
	this.materia=materia;
}


public String getMateria() {
	return materia;
}


public void setMateria(String materia) {
	this.materia = materia;
}
}
