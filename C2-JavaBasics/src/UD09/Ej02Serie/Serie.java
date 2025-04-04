package UD09.Ej02Serie;

public class Serie implements Entregable{

	protected String titulo = "";
	protected int numTemp = 3;
	protected boolean entregado = false;
	protected String genero = "";
	protected String creador = "";

	Serie() {

	}

	Serie(String titulo, String creador) {
		this.titulo = titulo;
		this.creador = creador;

	}

	Serie(String titulo, int numTemp, String genero, String creador) {
		this.titulo = titulo;
		this.numTemp = numTemp;
		this.genero = genero;
		this.creador = creador;
	}

	public String toString(String titulo, int numTemp, boolean entregado, String genero, String creador) {
		String entregaSiNo = "";
		if (entregado) {
			entregaSiNo = "está entregada";

		} else {
			entregaSiNo = "no está entregada";
		}
		
		String informe = "El título de la serie es" + titulo + ", tiene " + numTemp 
				+ " temporadas, "+entregaSiNo+", es de género de "+genero+" y su autor/a es "+creador+".";
		return informe;

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}
	
	
	public boolean entregar(boolean entregado) {
		return false;
	}

	public boolean devolver(boolean entregado) {
		return true;
	}
	
	public String isEntregado(boolean entregado) {
		String estadoEntrega="";
		if(entregado) {
			estadoEntrega="entregado";
		}else {
			estadoEntrega="no entregado";
		}
		return estadoEntrega;
	}

	public String compareTo(Object a) {
		if (a instanceof Serie) {
			Serie otraSerie = (Serie)a;
			if(this.numTemp > otraSerie.getNumTemp()) {
				return "La serie "+this.titulo+" tiene más temporadas que "+otraSerie.getTitulo();
			}else if (this.numTemp < otraSerie.getNumTemp()) {
				return "La serie "+this.titulo+" tiene menos temporadas que "+otraSerie.getTitulo();
			}else {
				return "La serie "+this.titulo+" tiene el mismo número de temporadas que "+otraSerie.getTitulo();
			}
		}else {			
		
		return "El objeto no es una serie.";
	}
	}
}

