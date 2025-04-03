package UD09.Ej02Serie;

public class Videojuego implements Entregable{

	protected String titulo="";
	protected double horasEstimadas=10;
	protected boolean entregado = false;
	protected String genero="";
	protected String empresa="";
	
	
	Videojuego(){
		
	}
	Videojuego(String titulo, double horasEstimadas){
		this.titulo=titulo;
		this.horasEstimadas=horasEstimadas;		
	}
	Videojuego(String titulo, double horasEstimadas, String genero, String empresa){
		this.titulo=titulo;
		this.horasEstimadas=horasEstimadas;	
		this.genero=genero;
		this.empresa=empresa;
	}
	
	public String toString(String titulo, double horasEstimadas, boolean entregado, String genero, String empresa) {
		String entregaSiNo = "";
		if (entregado) {
			entregaSiNo = "está entregada";

		} else {
			entregaSiNo = "no está entregada";
		}
		
		String informe = "El título de la serie es" + titulo + ", tiene " + horasEstimadas 
				+ " temporadas, "+entregaSiNo+", es de género de "+genero+" y su autor/a es "+empresa+".";
		return informe;

	}
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(double horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
	if (a instanceof Videojuego) {
		Videojuego otroVideojuego = (Videojuego)a;
		if(this.horasEstimadas > otroVideojuego.getHorasEstimadas()) {
			return "El videojuego "+this.titulo+" tiene más horas de juego estimadas que "+otroVideojuego.getTitulo();
		}else if (this.horasEstimadas < otroVideojuego.getHorasEstimadas()) {
			return "El videojuego "+this.titulo+" tiene menos horas de juego estimadas que "+otroVideojuego.getTitulo();
		}else {
			return "El videojuego "+this.titulo+" tiene el mismo número de horas de juego estimadas que "+otroVideojuego.getTitulo();
		}
	}else {
		return "El objeto no es un videojuego.";
	}
	
}
}
