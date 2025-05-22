package UD19.GrupalCalculadora;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

public class Calculadora extends JFrame {
	private JPanel contentPane;
	private JTextField textoPantalla;
	private JButton btnSuma;
	private JButton btn3;
	private JButton btn2;
	private JButton btn1;
	private JButton btnResta;
	private JButton btn6;
	private JButton btn5;
	private JButton btn4;
	private JButton btnMulti;
	private JButton btn9;
	private JButton btn8;
	private JButton btn7;
	private JButton btnDiv;
	private JButton btnIgual;
	private JButton btnCero;
	private JButton btnDecimal;
	private JButton btnRaiz;
	private JButton btnElevacion;

	double numero1;
	double numero2;
	double resultado;
	String operacion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculadora() {
		setTitle("Calculadora");
		setBounds(100, 100, 261, 395);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textoPantalla = new JTextField();
		textoPantalla.setBounds(10, 11, 230, 40);
		contentPane.add(textoPantalla);

		btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1 = Double.parseDouble(textoPantalla.getText());
				textoPantalla.setText("");
				operacion = "+";
			}
		});
		btnSuma.setBounds(190, 120, 50, 48);
		btnSuma.setFont(new Font("Arial", Font.BOLD, 18));
		btnSuma.setBackground(new Color(255, 255, 255));
		contentPane.add(btnSuma);

		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btn3.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn3.setFont(new Font("Arial", Font.BOLD, 18));
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setBounds(130, 238, 50, 48);

		contentPane.add(btn3);

		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btn2.getText();
				textoPantalla.setText(IngreseNumero);
			}

		});
		btn2.setFont(new Font("Arial", Font.BOLD, 18));
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setBounds(70, 238, 50, 48);
		contentPane.add(btn2);

		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btn1.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});

		btn1.setFont(new Font("Arial", Font.BOLD, 18));
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBounds(10, 238, 50, 48);
		contentPane.add(btn1);

		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btn9.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn9.setFont(new Font("Arial", Font.BOLD, 18));
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setBounds(130, 120, 50, 48);
		contentPane.add(btn9);

		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btn7.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn7.setFont(new Font("Arial", Font.BOLD, 18));
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setBounds(10, 120, 50, 48);
		contentPane.add(btn7);

		btnResta = new JButton("-");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btnResta.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});

		btnResta.setFont(new Font("Arial", Font.BOLD, 18));
		btnResta.setBackground(new Color(255, 255, 255));
		btnResta.setBounds(190, 179, 50, 48);
		contentPane.add(btnResta);

		btnMulti = new JButton("*");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btnMulti.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});

		btnMulti.setFont(new Font("Arial", Font.BOLD, 18));
		btnMulti.setBackground(new Color(255, 255, 255));
		btnMulti.setBounds(190, 238, 50, 48);
		contentPane.add(btnMulti);

		btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btnDiv.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});

		btnDiv.setFont(new Font("Arial", Font.BOLD, 18));
		btnDiv.setBackground(new Color(255, 255, 255));
		btnDiv.setBounds(10, 297, 50, 48);
		contentPane.add(btnDiv);

		btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btnIgual.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});

		btnIgual.setFont(new Font("Arial", Font.BOLD, 18));
		btnIgual.setBackground(new Color(255, 255, 255));
		btnIgual.setBounds(190, 297, 50, 48);
		contentPane.add(btnIgual);

		btnDecimal = new JButton(".");
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btnDecimal.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});

		btnDecimal.setFont(new Font("Arial", Font.BOLD, 18));
		btnDecimal.setBackground(new Color(255, 255, 255));
		btnDecimal.setBounds(130, 295, 50, 48);
		contentPane.add(btnDecimal);

		btnRaiz = new JButton("√");
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btnRaiz.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});

		btnRaiz.setFont(new Font("Arial", Font.BOLD, 18));
		btnRaiz.setBackground(new Color(255, 255, 255));
		btnRaiz.setBounds(10, 50, 50, 48);
		contentPane.add(btnRaiz);

		btnElevacion = new JButton("^");
		btnElevacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btnElevacion.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});

		btnElevacion.setFont(new Font("Arial", Font.BOLD, 18));
		btnElevacion.setBackground(new Color(255, 255, 255));
		btnElevacion.setBounds(50, 50, 50, 48);
		contentPane.add(btnElevacion);

		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btn6.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn6.setFont(new Font("Arial", Font.BOLD, 18));
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setBounds(130, 179, 50, 48);
		contentPane.add(btn6);

	}

}