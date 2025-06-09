package com.example.model;


import java.util.ArrayList;
import java.util.List;

public class Barco {
    private int tamaño;
    private List<int[]> posiciones; // Lista de posiciones [fila, columna]
    private boolean hundido;

    public Barco(int tamaño) {
        this.tamaño = tamaño;
        this.posiciones = new ArrayList<>();
        this.hundido = false;
    }

    public void agregarPosicion(int fila, int columna) {
        posiciones.add(new int[]{fila, columna});
    }

    public List<int[]> getPosiciones() {
        return posiciones;
    }
    public void setPosiciones(List<int[]> posiciones) {
        this.posiciones = posiciones;
    }
    public boolean verificarHundimiento(List<int[]> impactos) {
        for (int[] posicion : posiciones) {
            boolean impactado = false;
            for (int[] impacto : impactos) {
                if (impacto[0] == posicion[0] && impacto[1] == posicion[1]) {
                    impactado = true;
                    break;
                }
            }
            if (!impactado) {
                return false; // Aún hay partes del barco sin impactar
            }
        }
        hundido = true;
        return true; // Todas las partes del barco han sido impactadas
    }

    public boolean isHundido() {
        return hundido;
    }
}
