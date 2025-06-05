package com.example.model;


import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private List<Barco> barcos;
    private List<int[]> impactos; // Lista de posiciones impactadas

    public Tablero() {
        barcos = new ArrayList<>();
        impactos = new ArrayList<>();
    }

    public void agregarBarco(Barco barco) {
        barcos.add(barco);
    }

    public List<Barco> getBarcos() {
        return barcos;
    }

    public boolean registrarImpacto(int fila, int columna) {
        impactos.add(new int[]{fila, columna});
        for (Barco barco : barcos) {
            if (barco.verificarHundimiento(impactos)) {
                System.out.println("¡Barco hundido!");
            }
        }
        return true;
    }
}
