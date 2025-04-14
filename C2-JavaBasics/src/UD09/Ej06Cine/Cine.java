package UD09.Ej06Cine;

import java.util.Random;

import javax.swing.JOptionPane;

public class Cine {
	private final double precio = 7.50;
	private Asiento[][] asientos = new Asiento[8][9];
	private Pelicula pelicula;
	private Random random = new Random();

	public Cine(Pelicula pelicula) {
		this.pelicula = pelicula;
		inicializarAsientos();
	}

	private void inicializarAsientos() {
		char letra = 'A';
		for (int i = 0; i < 9; i++) { // Columnas
			for (int j = 0; j < 8; j++) { // Filas
				asientos[j][i] = new Asiento(letra + String.valueOf(8 - j)); // Etiqueta como "8A", "7B", etc.
			}
			letra++;
		}
	}

	// Método para mostrar el estado actual de los asientos en la sala
	public void mostrarAsientos() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(asientos[i][j].getIdentifier() + (asientos[i][j].isTaken() ? " (X)" : " ( )") + " ");
			}
			System.out.println();
		}
	}

	public void sentarEspectadorManual(Espectador espectador) {
		// Validación de edad mínima
		if (espectador.getEdad() < pelicula.getEdadMinima()) {
			JOptionPane.showMessageDialog(null, "El espectador no cumple la edad mínima para ver la película.");
			return;
		}

		// Validación de dinero disponible
		if (espectador.getDineroDisponible() < precio) {
			JOptionPane.showMessageDialog(null, "El espectador no tiene suficiente dinero para comprar la entrada.");
			return;
		}
		int numentradas = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero de entradas:"));

		for (int intentos = 0; intentos < numentradas; intentos++) {
			int fila = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero de fila:"));
			int columna = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero de columna:"));

			if (!asientos[fila][columna].isTaken()) {
				asientos[fila][columna].setTaken(true);
			} else {
				JOptionPane.showMessageDialog(null, "El asiento ya está ocupado.");
				intentos--; // El asiento ya está ocupado y no se intenta sentar al espectador
			}
		}
	}

	// Sentar al espectador en un asiento aleatorio disponible
	public void sentarEspectadorAleatorio(Espectador espectador) {
		// Validación de edad mínima
		if (espectador.getEdad() < pelicula.getEdadMinima()) {
			return;
		}

		// Validación de dinero disponible
		if (espectador.getDineroDisponible() < precio) {
			return;
		}

		// Intentar sentar al espectador en un asiento libre aleatorio
		for (int intentos = 0; intentos < 100; intentos++) {
			int fila = random.nextInt(8);
			int columna = random.nextInt(9);

			if (!asientos[fila][columna].isTaken()) {
				asientos[fila][columna].setTaken(true);
				return;
			}
		}
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public double getPrecio() {
		return precio;
	}
}