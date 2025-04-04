package UD09.Ej06Cine;

import java.util.Random;

public class Prueba {
    public static void main(String[] args) {
        // Initialize the 8x9 array of Seat objects
        Asiento[][] asientos = new Asiento[8][9];

        // Fill the array with Seat objects
        char letter = 'A';
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                asientos[j][i] = new Asiento(letter + String.valueOf(8 - j));
            }
            letter++;
        }

        // Print the array
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(asientos[i][j].getIdentifier() + " ");
            }
            System.out.println();
        }

        // Randomly mark seats as taken
        ocuparAsientosRandom(asientos, 30);

        // Print the array with seat statuses
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(asientos[i][j].getIdentifier() + (asientos[i][j].isTaken() ? " (X)" : " ( )") + " ");
            }
            System.out.println();
        }
    }

    // Method to randomly mark a specified number of seats as taken
    public static void ocuparAsientosRandom(Asiento[][] asientos, int numAsientos) {
        Random random = new Random();
        int filas = asientos.length;
        int cols = asientos[0].length;
        int asientosMarcados = 0;

        while (asientosMarcados < numAsientos) {
            int row = random.nextInt(filas);
            int col = random.nextInt(cols);

            if (!asientos[row][col].isTaken()) {
                asientos[row][col].setTaken(true);
                asientosMarcados++;
            }
        }
    }
}