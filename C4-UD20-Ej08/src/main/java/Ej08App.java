
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.awt.event.ActionEvent;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Ej08App extends JFrame {

	private JPanel contentPane;
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JButton btn1;
	private JButton btn2;
	private JButton btnBorrar;
	private JTextField text1;
	private JTextField text2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej08App frame = new Ej08App();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), // Mensaje de error
							"Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
	}

	public Ej08App() {

		setTitle("Ejercicio 3");
		setBounds(550, 150, 375, 275);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(45, 170, 120));

		etiqueta1 = new JLabel("Cantidad a convertir");
		etiqueta1.setBounds(20, 20, 325, 100);
		etiqueta1.setFont(new Font("Arial", Font.BOLD, 19));
		contentPane.add(etiqueta1);

		text1 = new JTextField();
		text1.setBounds(220, 55, 135, 30);
		text1.setFont(new Font("Arial", Font.BOLD, 19));
		contentPane.add(text1);

		etiqueta2 = new JLabel("Resultado");
		etiqueta2.setBounds(20, 70, 325, 100);
		etiqueta2.setFont(new Font("Arial", Font.BOLD, 19));
		contentPane.add(etiqueta2);

		text2 = new JTextField();
		text2.setBounds(220, 105, 135, 30);
		text2.setFont(new Font("Arial", Font.BOLD, 19));
		contentPane.add(text2);

		btn1 = new JButton("Euros a ptas");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double cambio;
					if (btn1.getText().equals("Euros a ptas")) {
						cambio = Double.parseDouble(text1.getText()) * 166.386;
					} else if (btn1.getText().equals("Ptas a euros")) {
						cambio = Double.parseDouble(text1.getText()) / 166.386;
					} else {
						throw new IllegalArgumentException("Operación no válida");
					}
					DecimalFormatSymbols symbols = new DecimalFormatSymbols();
					symbols.setDecimalSeparator('.');
					DecimalFormat df = new DecimalFormat("#.##", symbols);
					text2.setText(String.valueOf(df.format(cambio)));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error de entrada",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn1.setBounds(30, 145, 140, 30);
		btn1.setFont(new Font("Arial", Font.BOLD, 12));
		btn1.setBackground(new Color(160, 181, 81));
		contentPane.add(btn1);

		btn2 = new JButton("Cambiar");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText("Ptas a euros");

			}
		});
		btn2.setBounds(200, 145, 140, 30);
		btn2.setFont(new Font("Arial", Font.BOLD, 12));
		btn2.setBackground(new Color(160, 181, 81));
		contentPane.add(btn2);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1.setText("");
				text2.setText("");

			}
		});
		btnBorrar.setBounds(115, 190, 140, 30);
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnBorrar.setBackground(new Color(252, 81, 81));
		contentPane.add(btnBorrar);
	}
}