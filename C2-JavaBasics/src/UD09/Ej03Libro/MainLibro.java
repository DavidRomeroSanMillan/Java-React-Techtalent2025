package UD09.Ej03Libro;

public class MainLibro {

	public static void main(String[] args) {
		Libro NombreViento = new Libro("El Nombre del Viento", "8401352347", "Patrick Rothfuss", 880);
		Libro CiudadPerros = new Libro("La ciudad y los perros", "8420412333", "Mario Vargas Llosa", 768);
		Libro[] array = { NombreViento, CiudadPerros };
		imprimir(array);
		valorMasAlto(array);

	}

	private static void imprimir(Libro[] array) {
		for (Libro b : array) {
			System.out.println(b.toString());
		}
	}

	private static void valorMasAlto(Libro[] array) {
		int maxPag = 0;
		String maxTitle = "";
		for (Libro a : array) {
			if (a.getNumPg() > maxPag) {
				maxPag = a.getNumPg();
				maxTitle = a.getTitulo();
			}
		}
		System.out.println("El libro con más páginas es " + maxTitle + " con " + maxPag + ".");
	}
}
