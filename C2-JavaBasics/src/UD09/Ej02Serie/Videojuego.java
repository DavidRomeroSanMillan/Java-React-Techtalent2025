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
	@Override
	public String toString() {
		String entregaSiNo = "";
		if (entregado) {
			entregaSiNo = "está entregada";

		} else {
			entregaSiNo = "no está entregada";
		}
		
		String informe = titulo + ", tiene " + horasEstimadas 
				+ " horas de juego estimadas, "+entregaSiNo+", es de género de "+genero+" y la compañía que lo ha hecho es "+empresa+".";
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
	
	public String isEntregado(boolean entregado) {
		String estadoEntrega="";
		if(entregado) {
			estadoEntrega="entregado";
		}else {
			estadoEntrega="no entregado";
		}
		return estadoEntrega;
	}

	
	@Override
    public void entregar() {
        this.entregado = true;
    }

    @Override
    public void devolver() {
        this.entregado = false;
    }

    @Override
    public boolean isEntregado() {
        return this.entregado;
    }

    @Override
    public int compareTo(Object a) {
        if (a instanceof Videojuego) {
            Videojuego otroVideojuego = (Videojuego) a;
            return Double.compare(this.horasEstimadas, otroVideojuego.getHorasEstimadas());
        }
        return 0;
    }

   
}

