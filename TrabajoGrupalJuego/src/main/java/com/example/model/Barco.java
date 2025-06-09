package com.example.model;


import java.util.ArrayList;
import java.util.List;

public class Barco {
    private List<int[]> posiciones;
    private List<int[]> posicionesImpactadas = new ArrayList<>();
    private boolean hundido = false; // Declaración de la variable
    private int tamaño;

    public Barco(int tamaño) {
        this.tamaño = tamaño;
        this.posiciones = new ArrayList<>(tamaño);
    }

    public boolean contienePosicion(int fila, int columna) {
        for (int[] posicion : posiciones) {
            if (posicion[0] == fila && posicion[1] == columna) {
                posicionesImpactadas.add(new int[]{fila, columna});
                return true;
            }
        }
        return false;
    }


public boolean estaHundido() {
    for (int[] posicion : posiciones) {
        boolean impactada = false;
        for (int[] impacto : posicionesImpactadas) {
            if (impacto[0] == posicion[0] && impacto[1] == posicion[1]) {
                impactada = true;
                break;
            }
        }
        if (!impactada) {
            return false;
        }
    }
    return true;
}

    public void registrarImpacto(int fila, int columna) {
        for (int[] impacto : posicionesImpactadas) {
            if (impacto[0] == fila && impacto[1] == columna) {
                return; // Ya está registrado
            }
        }
        posicionesImpactadas.add(new int[]{fila, columna});
    }

    // Getters y setters
    public void setPosiciones(List<int[]> posiciones) {
        this.posiciones = posiciones;
    }

    public List<int[]> getPosiciones() {
        return posiciones;
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
        hundido = true; // Actualización del estado del barco
        return true; // Todas las partes del barco han sido impactadas
    }

    public boolean isHundido() {
        return hundido;
    }
}

