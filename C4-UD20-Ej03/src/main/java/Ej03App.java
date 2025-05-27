import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Ej03App extends JFrame{

	private JPanel contentPane;
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JButton btn1;
	private JButton btn2;
	private int contadorBtn1 = 0;
	private int contadorBtn2 = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej03App frame = new Ej03App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	public Ej03App() {

	setTitle("Ejercicio 3");
	setBounds(550, 150, 375, 375);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
	contentPane.setBackground(new Color (45, 170, 120));
	
	etiqueta1 = new JLabel("Botón 1 se ha pulsado " + contadorBtn1 + " veces");
	etiqueta1.setBounds(20, 20, 325, 100);
	etiqueta1.setFont(new Font("Arial", Font.BOLD, 19));
	contentPane.add(etiqueta1);
	
	etiqueta2 = new JLabel("Botón 2 se ha pulsado "+contadorBtn2+" veces.");
	etiqueta2.setBounds(20, 20, 325, 150);
	etiqueta2.setFont(new Font("Arial", Font.BOLD, 19));
	contentPane.add(etiqueta2);
	
	btn1 = new JButton("Botón 1");
	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contadorBtn1++;
			etiqueta1.setText("Botón 1 se ha pulsado "+ contadorBtn1+" veces.");
		}
	});
	btn1.setFont(new Font("Arial", Font.BOLD, 12));
	btn1.setBackground(new Color(176, 103, 140));
	btn1.setBounds(20, 120, 100, 100);
	contentPane.add(btn1);

	btn2 = new JButton("Botón 2");
	btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contadorBtn2++;
			etiqueta2.setText("Botón 2 se ha pulsado "+ contadorBtn2+" veces.");
	
		}
	});	
	btn2.setFont(new Font("Arial", Font.BOLD, 12));
	btn2.setBackground(new Color(17, 103, 140));
	btn2.setBounds(140, 120, 100, 100);
	contentPane.add(btn2);
	}
	
}
