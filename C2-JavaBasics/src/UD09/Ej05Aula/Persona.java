package UD09.Ej05Aula;

public class Persona {
protected String nombre = "";
protected int edad = 0;
protected String sexo = "";

Persona(String nombre, int edad, String sexo){
	this.nombre=nombre;
	this.edad=edad;
	this.sexo=sexo;
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

public String getSexo() {
	return sexo;
}

public void setSexo(String sexo) {
	this.sexo = sexo;
}
}
