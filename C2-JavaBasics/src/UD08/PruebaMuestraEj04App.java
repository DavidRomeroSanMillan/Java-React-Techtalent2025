package UD08;

public class PruebaMuestraEj04App {

	public static void main(String[] args) {
		Ej04Serie serie1 = new Ej04Serie();
		serie1.mostrarSerie();
		
		Ej04Serie serie2 = new Ej04Serie("Friends", "Marta Kauffman");
		serie2.mostrarSerie();
		
		Ej04Serie serie3 = new Ej04Serie("Friends", 7, "Sitcom", "Marta Kauffman");
		serie3.mostrarSerie();
	}

}
