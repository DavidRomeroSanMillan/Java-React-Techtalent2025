package com.example;

import com.example.model.Barco;
import com.example.model.Tablero;
import com.example.util.JugadoresDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HundirLaFlota {
	private JugadoresDAO jugadorDAO = new JugadoresDAO();

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
		frame.setResizable(true);
		crearMenu();
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

		// Llamar a iniciarJuego para solicitar los nombres antes de colocar los barcos
		iniciarJuego();

		// Permitir la colocación de barcos
		colocarBarcosInicial(botonesJugador1, tablero1);
		colocarBarcosInicial(botonesJugador2, tablero2);
	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuJuego = new JMenu("Juego");
		JMenuItem reiniciar = new JMenuItem("Reiniciar");
		JMenuItem salir = new JMenuItem("Salir");

		reiniciar.addActionListener(e -> reiniciarJuego());
		salir.addActionListener(e -> System.exit(0));

		menuJuego.add(reiniciar);
		menuJuego.add(salir);
		menuBar.add(menuJuego);
		frame.setJMenuBar(menuBar);
	}

	private void inicializarTablero(JButton[][] botones, JPanel panel, String jugador) {
		for (int i = 0; i < tamañoTablero; i++) {
			for (int j = 0; j < tamañoTablero; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBackground(Color.LIGHT_GRAY);
				panel.add(botones[i][j]);
			}
		}
		panel.setBorder(BorderFactory.createTitledBorder(jugador));
	}

	private String nombreJugador1;
	private String nombreJugador2;

	private String[] solicitarNombreYContraseña(String jugador) {
		JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
		JLabel labelNombre = new JLabel("Nombre:");
		JTextField campoNombre = new JTextField();
		JLabel labelContraseña = new JLabel("Contraseña:");
		JPasswordField campoContraseña = new JPasswordField();

		panel.add(labelNombre);
		panel.add(campoNombre);
		panel.add(labelContraseña);
		panel.add(campoContraseña);

		int opcion = JOptionPane.showConfirmDialog(frame, panel, "Introduce los datos del " + jugador,
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (opcion == JOptionPane.OK_OPTION) {
			String nombre = campoNombre.getText().trim();
			String contraseña = new String(campoContraseña.getPassword()).trim();
			if (nombre.isEmpty()) {
				nombre = jugador; // Nombre por defecto si está vacío
			}
			return new String[] { nombre, contraseña };
		} else {
			throw new IllegalArgumentException("Operación cancelada por el usuario.");
		}
	}

	private void iniciarJuego() {
		while (true) {
			try {
				// Solicitar datos del Jugador 1
				String[] datosJugador1 = solicitarNombreYContraseña("Jugador 1");
				jugadorDAO.insertarJugador(datosJugador1[0], datosJugador1[1]);

				// Solicitar datos del Jugador 2
				String[] datosJugador2 = solicitarNombreYContraseña("Jugador 2");
				jugadorDAO.insertarJugador(datosJugador2[0], datosJugador2[1]);

				// Asignar nombres y actualizar bordes
				nombreJugador1 = datosJugador1[0];
				nombreJugador2 = datosJugador2[0];
				tableroJugador1.setBorder(BorderFactory.createTitledBorder(nombreJugador1));
				tableroJugador2.setBorder(BorderFactory.createTitledBorder(nombreJugador2));

				break; // Salir del bucle si todo es correcto
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		mensajeEstado.setText("Turno de " + nombreJugador1 + ". Selecciona una casilla en el tablero del oponente.");

		mensajeEstado.setText("Turno de " + nombreJugador1 + ". Selecciona una casilla en el tablero del oponente.");
	}

	private void colocarBarcosInicial(JButton[][] tablero, Tablero logicaTablero) {
		int[] tamañosBarcos = { 5, 4, 3, 3, 2 };
		final int[] indiceBarco = { 0 };
		final List<int[]> posicionesSeleccionadas = new ArrayList<>();

		mensajeEstado.setText("Selecciona " + tamañosBarcos[indiceBarco[0]] + " casillas para colocar un barco.");

		habilitarTablero(tablero, true); // Asegúrate de habilitar el tablero para interactuar

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				final int fila = i; // Capturar el valor actual de i
				final int columna = j; // Capturar el valor actual de j
				JButton boton = tablero[i][j];
				for (ActionListener listener : boton.getActionListeners()) {
					boton.removeActionListener(listener);
				}
				boton.addActionListener(e -> {
					if (boton.getBackground().equals(Color.LIGHT_GRAY)
							&& posicionesSeleccionadas.size() < tamañosBarcos[indiceBarco[0]]) {
						boton.setBackground(Color.BLACK);
						posicionesSeleccionadas.add(new int[] { fila, columna }); // Usar fila y columna
						if (posicionesSeleccionadas.size() == tamañosBarcos[indiceBarco[0]]) {
							if (validarBarcoSeleccionado(posicionesSeleccionadas, logicaTablero)) {
								Barco barco = new Barco(tamañosBarcos[indiceBarco[0]]);
								barco.setPosiciones(new ArrayList<>(posicionesSeleccionadas));
								logicaTablero.agregarBarco(barco);
								posicionesSeleccionadas.clear();
								indiceBarco[0]++;
								if (indiceBarco[0] < tamañosBarcos.length) {
									mensajeEstado.setText("Selecciona " + tamañosBarcos[indiceBarco[0]]
											+ " casillas para colocar un barco.");
								} else {
									mensajeEstado.setText("Todos los barcos del jugador han sido colocados.");
									habilitarTablero(tablero, false);

									// Restablecer las casillas negras a gris claro
									for (int x = 0; x < tablero.length; x++) {
										for (int y = 0; y < tablero[x].length; y++) {
											if (tablero[x][y].getBackground().equals(Color.BLACK)) {
												tablero[x][y].setBackground(Color.LIGHT_GRAY);
											}
										}
									}

									// Verificar si es el tablero del segundo jugador
									if (logicaTablero == tablero2) {
										mensajeEstado
												.setText("¡Todos los barcos han sido colocados! Comienza el juego.");
										habilitarTablero(botonesJugador2, true); // Habilitar el tablero del jugador 2
										habilitarTablero(botonesJugador1, false); // Deshabilitar el tablero del jugador
																					// 1

										// Asignar ActionListener para manejar disparos

										for (int filaActual = 0; filaActual < tamañoTablero; filaActual++) {
											for (int columnaActual = 0; columnaActual < tamañoTablero; columnaActual++) {
												final int filaSeleccionada = filaActual;
												final int columnaSeleccionada = columnaActual;
												botonesJugador2[filaActual][columnaActual]
														.addActionListener(evento -> manejarDisparo(
																botonesJugador2[filaSeleccionada][columnaSeleccionada],
																filaSeleccionada, columnaSeleccionada, tablero2,
																botonesJugador2));
												botonesJugador1[filaActual][columnaActual]
														.addActionListener(evento -> manejarDisparo(
																botonesJugador1[filaSeleccionada][columnaSeleccionada],
																filaSeleccionada, columnaSeleccionada, tablero1,
																botonesJugador1));
											}
										}

									}
								}

							} else {
								JOptionPane.showMessageDialog(frame, "Selección inválida. Intenta nuevamente.");
								resetearSeleccion(tablero, posicionesSeleccionadas);
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
		if (posiciones.isEmpty()) {
			return false;
		}

		// Validar que las posiciones estén dentro de los límites del tablero
		for (int[] posicion : posiciones) {
			if (posicion[0] < 0 || posicion[0] >= tamañoTablero || posicion[1] < 0 || posicion[1] >= tamañoTablero) {
				return false;
			}
		}

		// Verificar si están en la misma fila o columna
		boolean mismaFila = true;
		boolean mismaColumna = true;
		int filaInicial = posiciones.get(0)[0];
		int columnaInicial = posiciones.get(0)[1];

		for (int[] posicion : posiciones) {
			if (posicion[0] != filaInicial) {
				mismaFila = false;
			}
			if (posicion[1] != columnaInicial) {
				mismaColumna = false;
			}
		}

		if (!mismaFila && !mismaColumna) {
			return false;
		}

		final boolean esMismaFila = mismaFila;

		// Verificar que las posiciones sean consecutivas
		posiciones.sort((a, b) -> esMismaFila ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

		for (int i = 1; i < posiciones.size(); i++) {
			int[] anterior = posiciones.get(i - 1);
			int[] actual = posiciones.get(i);

			if (mismaFila && actual[1] != anterior[1] + 1) {
				return false;
			}
			if (mismaColumna && actual[0] != anterior[0] + 1) {
				return false;
			}
		}

		// Verificar que no se superpongan con otros barcos
		for (int[] posicion : posiciones) {
			for (Barco existente : logicaTablero.getBarcos()) {
				for (int[] posicionExistente : existente.getPosiciones()) {
					if (posicion[0] == posicionExistente[0] && posicion[1] == posicionExistente[1]) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private void resetearSeleccion(JButton[][] tablero, List<int[]> posicionesSeleccionadas) {
		for (int[] posicion : posicionesSeleccionadas) {
			tablero[posicion[0]][posicion[1]].setBackground(Color.LIGHT_GRAY);
		}
		posicionesSeleccionadas.clear();
	}

	private boolean verificarDerrota(Tablero logicaTablero) {
		for (Barco barco : logicaTablero.getBarcos()) {
			if (!barco.estaHundido()) {
				return false; // Si hay al menos un barco no hundido, el jugador no ha perdido
			}
		}
		return true; // Todos los barcos están hundidos
	}

	private void ocultarBarcos(JButton[][] botones, Tablero logicaTablero) {
		for (Barco barco : logicaTablero.getBarcos()) {
			for (int[] posicion : barco.getPosiciones()) {
				botones[posicion[0]][posicion[1]].setBackground(Color.LIGHT_GRAY);
			}
		}
	}

	private void reiniciarJuego() {
		// Reiniciar los tableros
		for (int i = 0; i < tamañoTablero; i++) {
			for (int j = 0; j < tamañoTablero; j++) {
				// Eliminar todos los ActionListener existentes
				for (ActionListener listener : botonesJugador1[i][j].getActionListeners()) {
					botonesJugador1[i][j].removeActionListener(listener);
				}
				for (ActionListener listener : botonesJugador2[i][j].getActionListeners()) {
					botonesJugador2[i][j].removeActionListener(listener);
				}
				// Restablecer el color y habilitar los botones
				botonesJugador1[i][j].setBackground(Color.LIGHT_GRAY);
				botonesJugador1[i][j].setEnabled(true);
				botonesJugador2[i][j].setBackground(Color.LIGHT_GRAY);
				botonesJugador2[i][j].setEnabled(true);
			}
		}

		// Reiniciar la lógica de los tableros
		tablero1 = new Tablero();
		tablero2 = new Tablero();

		// Reiniciar variables
		esTurnoJugador1 = true;
		disparoRealizado = false;

		// Actualizar el mensaje de estado
		mensajeEstado.setText("Bienvenido al juego. ¡Coloca tus barcos!");

		// Permitir la colocación de barcos nuevamente
		colocarBarcosInicial(botonesJugador1, tablero1);
		colocarBarcosInicial(botonesJugador2, tablero2);
	}

	private boolean esTurnoJugador1 = true; // Variable para rastrear el turno actual

	private void cambiarTurno() {
		esTurnoJugador1 = !esTurnoJugador1; // Alternar el turno
		disparoRealizado = false; // Reiniciar la variable de control

		if (esTurnoJugador1) {
			habilitarTablero(botonesJugador1, false);
			habilitarTablero(botonesJugador2, true);
			mensajeEstado
					.setText("Turno de " + nombreJugador1 + ". Selecciona una casilla en el tablero del oponente.");
		} else {
			habilitarTablero(botonesJugador1, true);
			habilitarTablero(botonesJugador2, false);
			mensajeEstado
					.setText("Turno de " + nombreJugador2 + ". Selecciona una casilla en el tablero del oponente.");
		}

	}

	private boolean disparoRealizado = false; // Variable para controlar si ya se realizó un disparo en el turno actual

	private void manejarDisparo(JButton boton, int fila, int columna, Tablero logicaTablero,
			JButton[][] tableroBotones) {
		if (disparoRealizado) {
			JOptionPane.showMessageDialog(frame, "Ya realizaste tu disparo. Espera tu próximo turno.");
			return;
		}

		if (!boton.getBackground().equals(Color.LIGHT_GRAY)) {
			JOptionPane.showMessageDialog(frame, "Esta casilla ya ha sido seleccionada. Elige otra.");
			return;
		}

		if (logicaTablero.disparar(fila, columna)) { // Verifica si hay un barco en la posición
			boton.setBackground(Color.RED); // Acierto
			mensajeEstado.setText("¡Acierto! Turno del siguiente jugador.");

			// Verificar si el disparo hundió un barco
			for (Barco barco : logicaTablero.getBarcos()) {
				for (int[] posicion : barco.getPosiciones()) {
					if (posicion[0] == fila && posicion[1] == columna) {
						barco.registrarImpacto(fila, columna);
						if (barco.estaHundido()) {
							JOptionPane.showMessageDialog(frame, "¡Has hundido un barco!");
						}
						break;
					}
				}
			}
		} else {
			boton.setBackground(Color.BLUE); // Fallo
			mensajeEstado.setText("¡Fallo! Turno del siguiente jugador.");
		}

		disparoRealizado = true; // Marcar que el disparo ya se realizó

		// Verificar si el jugador oponente ha perdido

		if (verificarDerrota(logicaTablero)) {
			String ganador = esTurnoJugador1 ? nombreJugador1 : nombreJugador2;

			// Actualizar victorias en la base de datos
			jugadorDAO.actualizarVictorias(ganador);

			int opcion = JOptionPane.showOptionDialog(frame, "¡" + ganador + " ha ganado el juego! ¿Quieres reiniciar?",
					"Fin del juego", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Reiniciar", "Salir" }, "Reiniciar");

			if (opcion == JOptionPane.YES_OPTION) {
				reiniciarJuego(); // Reinicia el juego
			} else {
				System.exit(0); // Cierra la aplicación
			}
			return; // Detener el flujo del método
		}

		habilitarTablero(tableroBotones, false); // Deshabilitar el tablero del jugador actual
		SwingUtilities.invokeLater(this::cambiarTurno); // Cambiar el turno
	}

	public static void main(String[] args) {
		new HundirLaFlota();
	}
}
