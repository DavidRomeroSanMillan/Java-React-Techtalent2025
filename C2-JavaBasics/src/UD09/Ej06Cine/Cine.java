package UD09.Ej06Cine;

import java.util.Random;

import javax.swing.JOptionPane;

public class Cine {
    private final double precio = 7.50; // Precio fijo de la entrada
    private Asiento[][] asientos = new Asiento[8][9]; // Matriz de asientos (8 filas x 9 columnas)
    private Pelicula pelicula; // Película que se está proyectando
    private Random random = new Random(); // Random para asignar espectadores de forma aleatoria

    // Constructor: Inicializa la película y los asientos del cine
    public Cine(Pelicula pelicula) {
        this.pelicula = pelicula;
        inicializarAsientos(); // Llama al método para etiquetar los asientos correctamente
    }
    

    // Método para inicializar y etiquetar los asientos según el formato especificado (8A, 7B, etc.)
    private void inicializarAsientos() {
        char letra = 'A'; // Comienza con la columna 'A'
        for (int i = 0; i < 9; i++) { // Columnas
            for (int j = 0; j < 8; j++) { // Filas
                asientos[j][i] = new Asiento(letra + String.valueOf(8 - j)); // Etiqueta como "8A", "7B", etc.
            }
            letra++; // Pasa a la siguiente columna ('B', 'C', etc.)
        }
    }

    // Método para mostrar el estado actual de los asientos en la sala
    public void mostrarAsientos() {
        for (int i = 0; i < 8; i++) { // Filas
            for (int j = 0; j < 9; j++) { // Columnas
                System.out.print(asientos[i][j].getIdentifier() + (asientos[i][j].isTaken() ? " (X)" : " ( )") + " ");
            }
            System.out.println();
        }
    }
    
    public void sentarEspectadorManual(Espectador espectador) {
        // Validación de edad mínima
        if (espectador.getEdad() < pelicula.getEdadMinima()) {
        	JOptionPane.showMessageDialog(null, "El espectador no cumple la edad mínima para ver la película.");
            return; // El espectador no cumple la edad mínima y no se intenta sentarlo
        }

        // Validación de dinero disponible
        if (espectador.getDineroDisponible() < precio) {
        	JOptionPane.showMessageDialog(null, "El espectador no tiene suficiente dinero para comprar la entrada.");
            return; // El espectador no tiene suficiente dinero y no se intenta sentarlo
        }
        int numentradas = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero de entradas:")); 
        
        for (int intentos = 0; intentos < numentradas; intentos++) { // Máximo 100 intentos aleatorios
            int fila = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero de fila:")); // Fila aleatoria (0 a 7)
            int columna = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero de columna:")); // Columna aleatoria (0 a 8)

            if (!asientos[fila][columna].isTaken()) { // Si el asiento está libre
                asientos[fila][columna].setTaken(true); // Marcar como ocupado
            }
            else {
            	JOptionPane.showMessageDialog(null, "El asiento ya está ocupado.");
            	 intentos--; // El asiento ya está ocupado y no se intenta sentar al espectador
            }
        }
      }
    
        

    // Sentar al espectador en un asiento aleatorio disponible
    public void sentarEspectadorAleatorio(Espectador espectador) {
        // Validación de edad mínima
        if (espectador.getEdad() < pelicula.getEdadMinima()) {
            return; // El espectador no cumple la edad mínima y no se intenta sentarlo
        }

        // Validación de dinero disponible
        if (espectador.getDineroDisponible() < precio) {
            return; // El espectador no tiene suficiente dinero y no se intenta sentarlo
        }

        // Intentar sentar al espectador en un asiento libre aleatorio
        for (int intentos = 0; intentos < 100; intentos++) { // Máximo 100 intentos aleatorios
            int fila = random.nextInt(8); // Fila aleatoria (0 a 7)
            int columna = random.nextInt(9); // Columna aleatoria (0 a 8)

            if (!asientos[fila][columna].isTaken()) { // Si el asiento está libre
                asientos[fila][columna].setTaken(true); // Marcar como ocupado
                return; // Se asignó el asiento, no necesitamos más intentos
            }
        }
    }

    // Devuelve la película proyectada
    public Pelicula getPelicula() {
        return pelicula;
    }

    // Devuelve el precio de la entrada
    public double getPrecio() {
        return precio;
    }
}