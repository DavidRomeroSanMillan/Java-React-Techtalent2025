
package UD09.Ej06Cine;

import java.util.Random;

public class Prueba {
    public static void main(String[] args) {
        // Lista de 10 películas
        Pelicula[] peliculas = {
            new Pelicula("Interstellar", 169, 10, "Christopher Nolan"),
            new Pelicula("Parasite", 132, 16, "Bong Joon-ho"),
            new Pelicula("The Lion King", 88, 3, "Jon Favreau"),
            new Pelicula("Avengers: Endgame", 181, 13, "Anthony y Joe Russo"),
            new Pelicula("Titanic", 195, 12, "James Cameron"),
            new Pelicula("The Matrix", 136, 15, "Lana y Lilly Wachowski"),
            new Pelicula("Toy Story 4", 100, 3, "Josh Cooley"),
            new Pelicula("Joker", 122, 18, "Todd Phillips"),
            new Pelicula("La La Land", 128, 10, "Damien Chazelle"),
            new Pelicula("Star Wars: The Empire Strikes Back", 124, 10, "Irvin Kershner")
        };

        // Seleccionar una película aleatoria
        Random random = new Random();
        Pelicula peliculaSeleccionada = peliculas[random.nextInt(peliculas.length)];

        // Crear el cine con la película seleccionada
        Cine cine = new Cine(peliculaSeleccionada);

        // Mostrar la película seleccionada
        System.out.println("Película actual:");
        System.out.println(cine.getPelicula());
        System.out.println();

        // Generar un número aleatorio de espectadores (entre 10 y 50)
        int numEspectadores = 10 + random.nextInt(30); // Genera un número entre 10 y 50

        // Crear espectadores aleatorios y sentarlos
        for (int i = 0; i < numEspectadores; i++) {
            String nombre = "Espectador" + (i + 1); // Nombre del espectador
            int edad = random.nextInt(120);         // Edad aleatoria entre 0 y 59
            double dinero = random.nextDouble() * 20; // Dinero aleatorio entre 0 y 20

            // Crear un espectador con los datos aleatorios
            Espectador espectador = new Espectador(nombre, edad, dinero);

            // Intentar sentarlo en un asiento aleatorio
            cine.sentarEspectadorAleatorio(espectador);
        }
        // Mostrar el estado inicial de los asientos
        cine.mostrarAsientos();
        // Introducir espectador manualmente con joptionpane
        String nombre = javax.swing.JOptionPane.showInputDialog("Introduce el nombre del espectador:");
        int edad = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce la edad del espectador:"));
        double dinero = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Introduce el dinero disponible del espectador:"));
        
        Espectador espectadorManual = new Espectador(nombre, edad, dinero);
        cine.sentarEspectadorManual(espectadorManual);
              
        
        // Mostrar el estado final de los asientos
        System.out.println("\nEstado final de los asientos:");
        cine.mostrarAsientos();
    }
}