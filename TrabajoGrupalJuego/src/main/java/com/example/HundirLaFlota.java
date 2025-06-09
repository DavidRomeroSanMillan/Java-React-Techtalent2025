
package com.example;

import com.example.model.Barco;
import com.example.model.Tablero;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HundirLaFlota {
	private JFrame frame;
	private JPanel tableroJugador1, tableroJugador2;
	private JButton[][] botonesJugador1, botonesJugador2;
	private JLabel mensajeEstado;
	private int tamañoTablero = 10;
	private Tablero tablero1, tablero2;

	public HundirLaFlota() {
		frame = new JFrame("Trabajo Grupal - Hundir la Flota");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLayout(new BorderLayout());

		mensajeEstado = new JLabel("Bienvenido al juego. ¡Coloca tus barcos!", SwingConstants.CENTER);
		mensajeEstado.setFont(new Font("Arial", Font.BOLD, 16));
		frame.add(mensajeEstado, BorderLayout.NORTH);

		tableroJugador1 = new JPanel(new GridLayout(tamañoTablero, tamañoTablero));
		botonesJugador1 = new JButton[tamañoTablero][tamañoTablero];
		inicializarTablero(botonesJugador1, tableroJugador1, "Jugador 1");

		tableroJugador2 = new JPanel(new GridLayout(tamañoTablero, tamañoTablero));
		botonesJugador2 = new JButton[tamañoTablero][tamañoTablero];
		inicializarTablero(botonesJugador2, tableroJugador2, "Jugador 2");

		tablero1 = new Tablero();
		tablero2 = new Tablero();

		JPanel panelTableros = new JPanel(new GridLayout(1, 2));
		panelTableros.add(tableroJugador1);
		panelTableros.add(tableroJugador2);
		frame.add(panelTableros, BorderLayout.CENTER);

		frame.setVisible(true);

		colocarBarcosInicial(botonesJugador1, tablero1);
		colocarBarcosInicial(botonesJugador2, tablero2);
	}

	private void inicializarTablero(JButton[][] botones, JPanel panel, String jugador) {
		for (int i = 0; i < tamañoTablero; i++) {
			for (int j = 0; j < tamañoTablero; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBackground(Color.BLUE);
				panel.add(botones[i][j]);
			}
		}
		panel.setBorder(BorderFactory.createTitledBorder(jugador));
	}



private void colocarBarcosInicial(JButton[][] tablero, Tablero logicaTablero) {
    int[] tamañosBarcos = {5, 4, 3, 3, 2};
    final int[] indiceBarco = {0}; // Índice para rastrear el barco actual
    final List<int[]> posicionesSeleccionadas = new ArrayList<>();

    mensajeEstado.setText("Selecciona " + tamañosBarcos[indiceBarco[0]] + " casillas para colocar un barco.");

    for (JButton[] fila : tablero) {
        for (JButton boton : fila) {
            boton.addActionListener(e -> {
                if (posicionesSeleccionadas.size() < tamañosBarcos[indiceBarco[0]]) {
                    for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                            if (tablero[i][j] == boton && boton.getBackground().equals(Color.BLUE)) {
                                boton.setBackground(Color.GRAY);
                                posicionesSeleccionadas.add(new int[]{i, j});
                                if (posicionesSeleccionadas.size() == tamañosBarcos[indiceBarco[0]]) {
                                    if (validarBarcoSeleccionado(posicionesSeleccionadas, logicaTablero)) {
                                        Barco barco = new Barco(tamañosBarcos[indiceBarco[0]]);
                                        barco.setPosiciones(new ArrayList<>(posicionesSeleccionadas));
                                        logicaTablero.agregarBarco(barco);
                                        posicionesSeleccionadas.clear();
                                        indiceBarco[0]++;
                                        if (indiceBarco[0] < tamañosBarcos.length) {
                                            mensajeEstado.setText("Selecciona " + tamañosBarcos[indiceBarco[0]] + " casillas para colocar un barco.");
                                        } else {
                                            mensajeEstado.setText("Todos los barcos han sido colocados.");
                                            habilitarTablero(tablero, true);

                                            // Verificar si ambos jugadores han colocado sus barcos
                                            if (logicaTablero == tablero2) {
                                                iniciarJuego(); // Comenzar el juego
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "Selección inválida. Intenta nuevamente.");
                                        resetearSeleccion(tablero, posicionesSeleccionadas);
                                    }
                                }
                                return;
                            }
                        }
                    }
                }
            });
        }
    }
}


private void habilitarTablero(JButton[][] tablero, boolean habilitar) {
    for (JButton[] fila : tablero) {
        for (JButton boton : fila) {
            boton.setEnabled(habilitar);
        }
    }
}


	private boolean validarBarcoSeleccionado(List<int[]> posiciones, Tablero logicaTablero) {
		// Verificar que las posiciones sean adyacentes y no se superpongan con otros
		// barcos
		for (int[] posicion : posiciones) {
			for (Barco existente : logicaTablero.getBarcos()) {
				for (int[] posicionExistente : existente.getPosiciones()) {
					if (posicion[0] == posicionExistente[0] && posicion[1] == posicionExistente[1]) {
						return false;
					}
				}
			}
		}
		return true; // Aquí puedes agregar más validaciones, como adyacencia
	}

	private void resetearSeleccion(JButton[][] tablero, List<int[]> posicionesSeleccionadas) {
		for (int[] posicion : posicionesSeleccionadas) {
			tablero[posicion[0]][posicion[1]].setBackground(Color.BLUE);
		}
		posicionesSeleccionadas.clear();
	}

	private boolean validarBarco(Barco barco, Tablero logicaTablero) {
		for (Barco existente : logicaTablero.getBarcos()) {
			for (int[] posicionExistente : existente.getPosiciones()) {
				for (int[] posicionNueva : barco.getPosiciones()) {
					if (posicionExistente[0] == posicionNueva[0] && posicionExistente[1] == posicionNueva[1]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private void iniciarJuego() {
	    ocultarBarcos(botonesJugador1, tablero1);
	    ocultarBarcos(botonesJugador2, tablero2);

	    habilitarTablero(botonesJugador2, true); // Habilitar el tablero del oponente (Jugador 2)
	    habilitarTablero(botonesJugador1, false); // Deshabilitar el tablero del Jugador 1

	    mensajeEstado.setText("Turno del Jugador 1. Selecciona una casilla en el tablero del oponente.");
	    alternarTurnos();
	}

	private void ocultarBarcos(JButton[][] botones, Tablero logicaTablero) {
		for (Barco barco : logicaTablero.getBarcos()) {
			for (int[] posicion : barco.getPosiciones()) {
				botones[posicion[0]][posicion[1]].setBackground(Color.BLUE);
			}
		}
	}


	private void alternarTurnos() {
	    final boolean[] turnoJugador1 = {true}; // Usar un arreglo para que sea mutable

	    for (JButton[] fila : botonesJugador2) {
	        for (JButton boton : fila) {
	            boton.addActionListener(e -> {
	                if (turnoJugador1[0]) {
	                    procesarDisparo(boton, tablero2, "Jugador 1");
	                    turnoJugador1[0] = false;

	                    // Habilitar tablero del Jugador 1 y deshabilitar el del Jugador 2
	                    habilitarTablero(botonesJugador1, true);
	                    habilitarTablero(botonesJugador2, false);

	                    mensajeEstado.setText("Turno del Jugador 2. Selecciona una casilla en el tablero del oponente.");
	                }
	            });
	        }
	    }

	    for (JButton[] fila : botonesJugador1) {
	        for (JButton boton : fila) {
	            boton.addActionListener(e -> {
	                if (!turnoJugador1[0]) {
	                    procesarDisparo(boton, tablero1, "Jugador 2");
	                    turnoJugador1[0] = true;

	                    // Habilitar tablero del Jugador 2 y deshabilitar el del Jugador 1
	                    habilitarTablero(botonesJugador2, true);
	                    habilitarTablero(botonesJugador1, false);

	                    mensajeEstado.setText("Turno del Jugador 1. Selecciona una casilla en el tablero del oponente.");
	                }
	            });
	        }
	    }
	}






private void procesarDisparo(JButton boton, Tablero logicaTablero, String jugador) {
    if (!boton.isEnabled()) {
        return; // Si el botón ya está deshabilitado, no hacer nada
    }

    for (int i = 0; i < tamañoTablero; i++) {
        for (int j = 0; j < tamañoTablero; j++) {
            if (botonesJugador1[i][j] == boton || botonesJugador2[i][j] == boton) {
                if (boton.getBackground().equals(Color.BLUE)) { // Verifica si el botón está en su estado inicial
                    if (logicaTablero.esImpacto(i, j)) {
                        boton.setBackground(Color.RED);
                        mensajeEstado.setText(jugador + " ha acertado un barco.");
                    } else {
                        boton.setBackground(Color.BLACK); // Cambiar a negro si no hay barco
                        mensajeEstado.setText(jugador + " ha fallado.");
                    }
                    boton.setEnabled(false); // Deshabilitar el botón después de disparar
                }
                return; // Salir del bucle una vez procesado el disparo
            }
        }
    }
}




	public static void main(String[] args) {
		new HundirLaFlota();
	}
}
