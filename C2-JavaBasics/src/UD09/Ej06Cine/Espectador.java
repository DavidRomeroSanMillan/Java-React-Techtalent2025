
package UD09.Ej06Cine;


//Representa a los espectadores que asisten al cine
public class Espectador {
 private String nombre;         
 private int edad;              
 private double dineroDisponible; 

 public Espectador(String nombre, int edad, double dineroDisponible) {
     this.nombre = nombre;
     this.edad = edad;
     this.dineroDisponible = dineroDisponible;
 }

 public String getNombre() {
     return nombre;
 }

 public int getEdad() {
     return edad;
 }

 public double getDineroDisponible() {
     return dineroDisponible;
 }

 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 public void setEdad(int edad) {
     this.edad = edad;
 }

 public void setDineroDisponible(double dineroDisponible) {
     this.dineroDisponible = dineroDisponible;
 }
}