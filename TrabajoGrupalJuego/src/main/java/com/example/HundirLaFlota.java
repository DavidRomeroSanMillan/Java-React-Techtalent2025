
package com.example;

import com.example.model.Barco;
import com.example.model.Tablero;

import javax.swing.*;
import java.awt.*;
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
        for (int tamaño : tamañosBarcos) {
            Barco barco = new Barco(tamaño);
            boolean colocado = false;

            while (!colocado) {
                JOptionPane.showMessageDialog(frame, "Selecciona las posiciones para un barco de tamaño " + tamaño);
                for (int i = 0; i < tamaño; i++) {
                    int fila = Integer.parseInt(JOptionPane.showInputDialog("Introduce la fila para la posición " + (i + 1)));
                    int columna = Integer.parseInt(JOptionPane.showInputDialog("Introduce la columna para la posición " + (i + 1)));

                    if (fila < 0 || fila >= tamañoTablero || columna < 0 || columna >= tamañoTablero ||
                        !tablero[fila][columna].getBackground().equals(Color.BLUE)) {
                        JOptionPane.showMessageDialog(frame, "Posición inválida. Intenta nuevamente.");
                        i--;
                    } else {
                        barco.agregarPosicion(fila, columna);
                    }
                }

                if (validarBarco(barco, logicaTablero)) {
                    logicaTablero.agregarBarco(barco);
                    for (int[] posicion : barco.getPosiciones()) {
                        tablero[posicion[0]][posicion[1]].setBackground(Color.GRAY);
                    }
                    colocado = true;
                } else {
                    JOptionPane.showMessageDialog(frame, "El barco se superpone con otro. Intenta nuevamente.");
                    barco = new Barco(tamaño);
                }
            }
        }
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

    public static void main(String[] args) {
        new HundirLaFlota();
    }
}
