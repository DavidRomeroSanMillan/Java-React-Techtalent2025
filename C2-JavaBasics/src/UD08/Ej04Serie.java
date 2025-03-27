package UD08;

public class Ej04Serie {
	private String titulo;
	private int numTemp;
	private boolean entregado;
	private String genero;
	private String creador;

	Ej04Serie() {
		this.titulo = "";
		this.numTemp = 3;
		this.entregado = false;
		this.genero = "";
		this.creador = "";

	}

	Ej04Serie(String titulo, String creador) {
		this.titulo = titulo;
		this.creador = creador;
		this.genero = "";
		this.numTemp = 3;
		this.entregado = false;

	}

	Ej04Serie(String titulo, int numTemp, String genero, String creador) {
		this.titulo = titulo;
		this.numTemp = numTemp;
		this.genero = genero;
		this.creador = creador;
		this.entregado = false;
	}

	public void mostrarSerie() {
		System.out.println("El título de la serie es " + this.titulo + ", el creador es " + this.creador + ", tiene "
				+ this.numTemp + " temporada/s, es de género de " + this.genero + " y su estado de entrega es: "
				+ this.entregado + ".");
	}

	public String getTitulo() {
		return titulo;

	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumTemp() {
		return numTemp;

	}

	public void setNumTemp(int numTemp) {
		this.numTemp = numTemp;
	}

	public boolean getEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
