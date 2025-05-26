package UD19.Tareas;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import UD19.GrupalCalculadora.Calculadora;

import java.awt.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class Ej01Saludador extends JFrame{
	private JPanel contentPane;
	private JButton boton;
	private JTextField textoPantalla;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej01Saludador frame = new Ej01Saludador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	public Ej01Saludador() {
		setTitle("Saludador");
		setBounds(550, 150, 275, 275);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(48, 51, 74));

		textoPantalla = new JTextField();
	    textoPantalla.setFont(new Font("Arial", Font.PLAIN, 16));
	    textoPantalla.setPreferredSize(new Dimension(200, 30));
		textoPantalla.setBounds(15, 11, 230, 42);
		contentPane.add(textoPantalla);
		
		boton = new JButton("¡Saluda!");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textoPantalla.getText();
				JOptionPane.showMessageDialog(rootPane, "¡Hola, " +nombre+"!");
			}
		});
		boton.setFont(new Font("Arial", Font.BOLD, 18));
		boton.setBackground(new Color(176, 103, 140));
		boton.setBounds(55, 70, 150, 150);
		contentPane.add(boton);

}
}