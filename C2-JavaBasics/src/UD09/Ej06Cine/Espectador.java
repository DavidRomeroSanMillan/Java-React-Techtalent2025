
package UD09.Ej06Cine;


//Representa a los espectadores que asisten al cine
public class Espectador {
 private String nombre;         // Nombre del espectador
 private int edad;              // Edad del espectador
 private double dineroDisponible; // Dinero que el espectador tiene disponible

 // Constructor: Inicializa los atributos del espectador
 public Espectador(String nombre, int edad, double dineroDisponible) {
     this.nombre = nombre;
     this.edad = edad;
     this.dineroDisponible = dineroDisponible;
 }

 // Devuelve el nombre del espectador
 public String getNombre() {
     return nombre;
 }

 // Devuelve la edad del espectador
 public int getEdad() {
     return edad;
 }

 // Devuelve el dinero disponible del espectador
 public double getDineroDisponible() {
     return dineroDisponible;
 }

 // Permite cambiar el nombre del espectador
 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 // Permite actualizar la edad del espectador
 public void setEdad(int edad) {
     this.edad = edad;
 }

 // Permite modificar el dinero disponible del espectador
 public void setDineroDisponible(double dineroDisponible) {
     this.dineroDisponible = dineroDisponible;
 }
}