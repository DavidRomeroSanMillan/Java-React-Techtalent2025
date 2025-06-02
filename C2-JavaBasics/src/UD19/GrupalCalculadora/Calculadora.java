package UD19.GrupalCalculadora;

import javax.swing.*;
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
import UD19.GrupalCalculadora.CalculadoraDAO;

import java.util.List;

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
	private JButton btnBorrar;
	private JButton btnPor;
	private JMenuBar menuBar;

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
		setBounds(100, 100, 261, 425);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(48, 51, 74));

		textoPantalla = new JTextField();
		textoPantalla.setBounds(10, 11, 230, 42);
		textoPantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		textoPantalla.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(textoPantalla);

		menuBar = new JMenuBar();
		JMenu historial = new JMenu("Historial");
		menuBar.add(historial);

		JMenuItem verHistorial = new JMenuItem("Ver Historial");
		verHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculadoraDAO calculadoraDAO = new CalculadoraDAO();
				List<String> historial = calculadoraDAO.obtenerHistorial();
				HistorialDialog dialog = new HistorialDialog(Calculadora.this, historial);
				dialog.setVisible(true);
			}
		});
		historial.add(verHistorial);
		setJMenuBar(menuBar);

		btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1 = Double.parseDouble(textoPantalla.getText());
				operacion = "+";
				textoPantalla.setText("");
			}
		});
		btnSuma.setBounds(190, 132, 50, 48);
		btnSuma.setFont(new Font("Arial", Font.BOLD, 18));
		btnSuma.setBackground(new Color(252, 81, 81));
		contentPane.add(btnSuma);

		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btn3.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn3.setFont(new Font("Arial", Font.BOLD, 18));
		btn3.setBackground(new Color(176, 173, 173));
		contentPane.add(btn3);

		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btn2.getText();
				textoPantalla.setText(IngreseNumero);
			}

		});
		btn2.setFont(new Font("Arial", Font.BOLD, 18));
		btn2.setBackground(new Color(226, 226, 226));
		btn2.setBounds(70, 250, 50, 48);
		contentPane.add(btn2);

		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btn1.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});

		btn1.setFont(new Font("Arial", Font.BOLD, 18));
		btn1.setBackground(new Color(226, 226, 226));
		btn1.setBounds(10, 250, 50, 48);
		contentPane.add(btn1);

		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btn9.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn9.setFont(new Font("Arial", Font.BOLD, 18));
		btn9.setBackground(new Color(226, 226, 226));
		btn9.setBounds(130, 132, 50, 48);
		contentPane.add(btn9);

		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btn7.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn7.setFont(new Font("Arial", Font.BOLD, 18));
		btn7.setBackground(new Color(226, 226, 226));
		btn7.setBounds(10, 132, 50, 48);
		contentPane.add(btn7);

		btnResta = new JButton("-");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1 = Double.parseDouble(textoPantalla.getText());
				operacion = "-";
				textoPantalla.setText("");

			}
		});

		btnResta.setFont(new Font("Arial", Font.BOLD, 18));
		btnResta.setBackground(new Color(252, 81, 81));
		btnResta.setBounds(190, 191, 50, 48);
		contentPane.add(btnResta);

		btnMulti = new JButton("*");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1 = Double.parseDouble(textoPantalla.getText());
				operacion = "*";
				textoPantalla.setText("");
			}
		});

		btnMulti.setFont(new Font("Arial", Font.BOLD, 18));
		btnMulti.setBackground(new Color(252, 81, 81));
		btnMulti.setBounds(190, 250, 50, 48);
		contentPane.add(btnMulti);

		btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1 = Double.parseDouble(textoPantalla.getText());
				operacion = "/";
				textoPantalla.setText("");
			}
		});

		btnDiv.setFont(new Font("Arial", Font.BOLD, 18));
		btnDiv.setBackground(new Color(252, 81, 81));
		btnDiv.setBounds(10, 309, 50, 48);
		contentPane.add(btnDiv);

		btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (operacion.equals("√")) {
					resultado = Operaciones.calcular(operacion, numero1);
					CalculadoraDAO calculadoraDAO = new CalculadoraDAO();
					String guardado = numero1 +""+ operacion;
					calculadoraDAO.guardarResultadoRaiz(guardado, resultado);
				} else {

					numero2 = Double.parseDouble(textoPantalla.getText());
					resultado = Operaciones.calcular(numero1, numero2, operacion);
					CalculadoraDAO calculadoraDAO = new CalculadoraDAO();
					String guardado = numero1 +""+ operacion +""+ numero2;
					calculadoraDAO.guardarResultado(guardado, resultado);
				}
				textoPantalla.setText(String.valueOf(resultado));

				// Guardar el resultado en la base de datos


			}
		});

		btnIgual.setFont(new Font("Arial", Font.BOLD, 18));
		btnIgual.setBackground(new Color(249, 207, 0));
		btnIgual.setBounds(190, 308, 50, 48);
		contentPane.add(btnIgual);

		btnDecimal = new JButton(".");
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IngreseNumero = textoPantalla.getText() + btnDecimal.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});

		btnDecimal.setFont(new Font("Arial", Font.BOLD, 18));
		btnDecimal.setBackground(new Color(82, 245, 120));
		btnDecimal.setBounds(130, 307, 50, 48);
		contentPane.add(btnDecimal);

		btnRaiz = new JButton("√");
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1 = Double.parseDouble(textoPantalla.getText());
				operacion = "√";
				textoPantalla.setText("");

			}
		});

		btnRaiz.setFont(new Font("Arial", Font.BOLD, 18));
		btnRaiz.setBackground(new Color(82, 245, 120));
		btnRaiz.setBounds(10, 72, 50, 48);
		contentPane.add(btnRaiz);

		btnElevacion = new JButton("^");
		btnElevacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1 = Double.parseDouble(textoPantalla.getText());
				operacion = "^";
				textoPantalla.setText("");
			}
		});

		btnElevacion.setFont(new Font("Arial", Font.BOLD, 18));
		btnElevacion.setBackground(new Color(82, 245, 120));
		btnElevacion.setBounds(70, 72, 50, 48);
		contentPane.add(btnElevacion);

		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btn6.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn6.setFont(new Font("Arial", Font.BOLD, 18));
		btn6.setBackground(new Color(226, 226, 226));
		btn6.setBounds(130, 191, 50, 48);
		contentPane.add(btn6);

		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btn8.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn8.setFont(new Font("Arial", Font.BOLD, 18));
		btn8.setBackground(new Color(226, 226, 226));
		btn8.setBounds(70, 132, 50, 48);
		contentPane.add(btn8);

		btnCero = new JButton("0");
		btnCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btnCero.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btnCero.setFont(new Font("Arial", Font.BOLD, 18));
		btnCero.setBackground(new Color(226, 226, 226));
		btnCero.setBounds(70, 308, 50, 48);
		contentPane.add(btnCero);

		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btn3.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn3.setFont(new Font("Arial", Font.BOLD, 18));
		btn3.setBackground(new Color(226, 226, 226));
		btn3.setBounds(130, 250, 50, 48);
		contentPane.add(btn3);

		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btn4.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn4.setFont(new Font("Arial", Font.BOLD, 18));
		btn4.setBackground(new Color(226, 226, 226));
		btn4.setBounds(10, 191, 50, 48);
		contentPane.add(btn4);

		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IngreseNumero = textoPantalla.getText() + btn5.getText();
				textoPantalla.setText(IngreseNumero);
			}
		});
		btn5.setFont(new Font("Arial", Font.BOLD, 18));
		btn5.setBackground(new Color(226, 226, 226));
		btn5.setBounds(70, 191, 50, 48);
		contentPane.add(btn5);

		btnBorrar = new JButton("<");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textoPantalla.getText();
				if (!texto.isEmpty()) {
					textoPantalla.setText("");
				}
			}
		});
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 18));
		btnBorrar.setBackground(new Color(72, 236, 236));
		btnBorrar.setBounds(190, 72, 50, 50);
		contentPane.add(btnBorrar);

		btnPor = new JButton("%");
		btnPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1 = Double.parseDouble(textoPantalla.getText());
				operacion = "%";
				textoPantalla.setText("");
			}
		});
		btnPor.setFont(new Font("Arial", Font.BOLD, 18));
		btnPor.setBackground(new Color(82, 245, 120));
		btnPor.setBounds(130, 72, 50, 50);
		contentPane.add(btnPor);
	}

}