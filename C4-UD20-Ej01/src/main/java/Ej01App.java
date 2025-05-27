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
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Ej01App extends JFrame{
	
	private JPanel contentPane;
	private JLabel etiquetaLabel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej01App frame = new Ej01App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
	public Ej01App() {
		setTitle("Ejercicio 1");
		setBounds(550, 150, 375, 375);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground( new Color (240, 50, 80));
		
		etiquetaLabel = new JLabel("Hola!");
		etiquetaLabel.setBounds(10, 20, 300, 300);
		etiquetaLabel.setFont(new Font ("Arial", Font.BOLD, 27 ));
		contentPane.add(etiquetaLabel);
		
	    JSlider slider = new JSlider(10, 100, 27); // Tamaño mínimo, máximo y valor inicial
	    slider.setBounds(10, 15, 300, 50);
	    slider.setMajorTickSpacing(10); //Intervalo entre rallitas
	    slider.setPaintTicks(true); //Pone las rallitas de la barra
	    slider.setPaintLabels(true); //Pone los numeritos de la barra
	    slider.setBackground(new Color (23,150,50));
	    
	    slider.addChangeListener(e -> {
	        int fontSize = slider.getValue(); // Obtener el valor actual del slider
	        etiquetaLabel.setFont(new Font("Arial", Font.BOLD, fontSize)); // Cambiar el tamaño de la fuente
	    });

	    contentPane.add(slider);
	}

}
