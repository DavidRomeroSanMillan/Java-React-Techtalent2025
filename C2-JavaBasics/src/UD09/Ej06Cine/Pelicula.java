package UD09.Ej06Cine;


//Representa la película que se proyecta en el cine
public class Pelicula {
 private String titulo;     // Título de la película
 private int duracion;      // Duración en minutos
 private int edadMinima;    // Edad mínima requerida para ver la película
 private String director;   // Nombre del director de la película

 // Constructor: Inicializa los atributos de la película
 public Pelicula(String titulo, int duracion, int edadMinima, String director) {
     this.titulo = titulo;
     this.duracion = duracion;
     this.edadMinima = edadMinima;
     this.director = director;
 }

 // Devuelve el título de la película
 public String getTitulo() {
     return titulo;
 }

 // Devuelve la duración de la película en minutos
 public int getDuracion() {
     return duracion;
 }

 // Devuelve la edad mínima requerida para ver la película
 public int getEdadMinima() {
     return edadMinima;
 }

 // Devuelve el nombre del director de la película
 public String getDirector() {
     return director;
 }

 // Representación en texto de la película (utilizado para imprimir su información)
 @Override
 public String toString() {
     return "Título: " + titulo + ", Duración: " + duracion + " min, Edad mínima: " + edadMinima + ", Director: " + director;
 }
}