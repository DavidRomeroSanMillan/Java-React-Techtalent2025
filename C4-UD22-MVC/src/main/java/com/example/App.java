
package com.example;

import javax.swing.SwingUtilities;

import com.example.view.Vista;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Vista vista = new Vista();
            vista.setVisible(true);
        });
    }
}