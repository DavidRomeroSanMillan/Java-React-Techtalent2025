package UD09.Ej06Cine;

public class Película {

	protected String titulo;
	protected double duracion;
	protected int edadMinima;
	protected String director;
	
	Película(String titulo, double duracion, int edadMinima, String director) {
		this.titulo=titulo;
		this.duracion=duracion;
		this.edadMinima=edadMinima;
		this.director=director;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	
}
