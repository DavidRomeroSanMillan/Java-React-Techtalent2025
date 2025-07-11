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
		frame = new JFrame("Hundir la Flota");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		crearMenu();
		mensajeEstado = new JLabel("¡Bienvenido a Hundir la Flota!", SwingConstants.CENTER);
		mensajeEstado.setFont(new Font("Verdana", Font.BOLD, 18));
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
		panelTableros.setBackground(new Color(0, 102, 204)); 

		panelTableros.add(tableroJugador1);
		panelTableros.add(tableroJugador2);
		frame.add(panelTableros, BorderLayout.CENTER);

		frame.setVisible(true);

		iniciarJuego();

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
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2),
				"Inicio de sesión - " + jugador, 0, 0, new Font("Verdana", Font.BOLD, 14), new Color(30, 144, 255)));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelNombre.setForeground(new Color(30, 144, 255));
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(labelNombre, gbc);

		JTextField campoNombre = new JTextField(15);
		campoNombre.setFont(new Font("Verdana", Font.PLAIN, 12));
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(campoNombre, gbc);

		JLabel labelContraseña = new JLabel("Contraseña:");
		labelContraseña.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelContraseña.setForeground(new Color(30, 144, 255));
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(labelContraseña, gbc);

		JPasswordField campoContraseña = new JPasswordField(15);
		campoContraseña.setFont(new Font("Verdana", Font.PLAIN, 12));
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(campoContraseña, gbc);

		int opcion = JOptionPane.showConfirmDialog(frame, panel, "Introduce los datos del " + jugador,
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (opcion == JOptionPane.OK_OPTION) {
			String nombre = campoNombre.getText().trim();
			String contraseña = new String(campoContraseña.getPassword()).trim();
			if (nombre.isEmpty()) {
				nombre = jugador;
			}
			return new String[] { nombre, contraseña };
		} else {
			frame.dispose();
			System.exit(0);
			return null;
		}
	}

	private void iniciarJuego() {
		while (true) {
			try {
				String[] datosJugador1 = solicitarNombreYContraseña("Jugador 1");
				jugadorDAO.insertarJugador(datosJugador1[0], datosJugador1[1]);

				String[] datosJugador2 = solicitarNombreYContraseña("Jugador 2");
				jugadorDAO.insertarJugador(datosJugador2[0], datosJugador2[1]);

				nombreJugador1 = datosJugador1[0];
				nombreJugador2 = datosJugador2[0];
				tableroJugador1.setBorder(BorderFactory.createTitledBorder(nombreJugador1));
				tableroJugador2.setBorder(BorderFactory.createTitledBorder(nombreJugador2));

				break; 
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

		habilitarTablero(tablero, true); 

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				final int fila = i; 
				final int columna = j; 
				JButton boton = tablero[i][j];
				for (ActionListener listener : boton.getActionListeners()) {
					boton.removeActionListener(listener);
				}
				boton.addActionListener(e -> {
					if (boton.getBackground().equals(Color.LIGHT_GRAY)
							&& posicionesSeleccionadas.size() < tamañosBarcos[indiceBarco[0]]) {
						boton.setBackground(Color.BLACK);
						posicionesSeleccionadas.add(new int[] { fila, columna }); 
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

									for (int x = 0; x < tablero.length; x++) {
										for (int y = 0; y < tablero[x].length; y++) {
											if (tablero[x][y].getBackground().equals(Color.BLACK)) {
												tablero[x][y].setBackground(Color.LIGHT_GRAY);
											}
										}
									}

									if (logicaTablero == tablero2) {
										mensajeEstado
												.setText("¡Todos los barcos han sido colocados! Comienza el juego.");
										habilitarTablero(botonesJugador2, true); 
										habilitarTablero(botonesJugador1, false); 


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

		for (int[] posicion : posiciones) {
			if (posicion[0] < 0 || posicion[0] >= tamañoTablero || posicion[1] < 0 || posicion[1] >= tamañoTablero) {
				return false;
			}
		}

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
				return false; 
			}
		}
		return true; 
	}

	private void ocultarBarcos(JButton[][] botones, Tablero logicaTablero) {
		for (Barco barco : logicaTablero.getBarcos()) {
			for (int[] posicion : barco.getPosiciones()) {
				botones[posicion[0]][posicion[1]].setBackground(Color.LIGHT_GRAY);
			}
		}
	}

	private void reiniciarJuego() {
		for (int i = 0; i < tamañoTablero; i++) {
			for (int j = 0; j < tamañoTablero; j++) {
				for (ActionListener listener : botonesJugador1[i][j].getActionListeners()) {
					botonesJugador1[i][j].removeActionListener(listener);
				}
				for (ActionListener listener : botonesJugador2[i][j].getActionListeners()) {
					botonesJugador2[i][j].removeActionListener(listener);
				}
				botonesJugador1[i][j].setBackground(Color.LIGHT_GRAY);
				botonesJugador1[i][j].setEnabled(true);
				botonesJugador2[i][j].setBackground(Color.LIGHT_GRAY);
				botonesJugador2[i][j].setEnabled(true);
			}
		}

		tablero1 = new Tablero();
		tablero2 = new Tablero();

		esTurnoJugador1 = true;
		disparoRealizado = false;

		mensajeEstado.setText("Bienvenido al juego. ¡Coloca tus barcos!");

		colocarBarcosInicial(botonesJugador1, tablero1);
		colocarBarcosInicial(botonesJugador2, tablero2);
	}

	private boolean esTurnoJugador1 = true; 

	private void cambiarTurno() {
		esTurnoJugador1 = !esTurnoJugador1; 
		disparoRealizado = false; 

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

	private boolean disparoRealizado = false; 

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

		if (logicaTablero.disparar(fila, columna)) { 
			boton.setBackground(Color.RED); 
			mensajeEstado.setText("¡Acierto! Turno del siguiente jugador.");

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
			boton.setBackground(Color.BLUE); 
			mensajeEstado.setText("¡Fallo! Turno del siguiente jugador.");
		}

		disparoRealizado = true; 


		if (verificarDerrota(logicaTablero)) {
			String ganador = esTurnoJugador1 ? nombreJugador1 : nombreJugador2;

			jugadorDAO.actualizarVictorias(ganador);

			int opcion = JOptionPane.showOptionDialog(frame, "¡" + ganador + " ha ganado el juego! ¿Quieres reiniciar?",
					"Fin del juego", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Reiniciar", "Salir" }, "Reiniciar");

			if (opcion == JOptionPane.YES_OPTION) {
				reiniciarJuego(); 
			} else {
				System.exit(0); 
			}
			return; 
		}

		habilitarTablero(tableroBotones, false); 
		SwingUtilities.invokeLater(this::cambiarTurno); 
	}

	public static void main(String[] args) {
		new HundirLaFlota();
	}
}
