package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
	private List<Barco> barcos;

	public Tablero() {
		this.barcos = new ArrayList<>();
	}

	public void agregarBarco(Barco barco) {
		barcos.add(barco);
	}

	public List<Barco> getBarcos() {
		return barcos;
	}

	public List<int[]> obtenerPosicionesDeBarcos() {
		List<int[]> posiciones = new ArrayList<>();
		for (Barco barco : barcos) {
			posiciones.addAll(barco.getPosiciones());
		}
		return posiciones;
	}

	public boolean disparar(int fila, int columna) {
		for (Barco barco : barcos) {
			if (barco.contienePosicion(fila, columna)) {
				return true; 
			}
		}
		return false; 
	}

	public boolean esImpacto(int x, int y) {
		for (Barco barco : barcos) { 
			for (int[] posicion : barco.getPosiciones()) {
				if (posicion[0] == x && posicion[1] == y) {
					return true; 
				}
			}
		}
		return false; 
	}
}
