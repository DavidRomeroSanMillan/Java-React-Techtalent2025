
package com.example.view;

import com.example.controller.Controlador;
import com.example.model.Cliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Vista extends JFrame {
	private Controlador controlador;
	private JTextField txtId, txtNombre, txtApellido, txtDireccion, txtDni, txtFecha;
	private JTextArea txtAreaClientes;

	public Vista() {
		controlador = new Controlador();
		setTitle("Gestión de Clientes");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Panel de entrada de datos
		JPanel panelDatos = new JPanel(new GridLayout(6, 2));
		panelDatos.add(new JLabel("ID:"));
		txtId = new JTextField();
		panelDatos.add(txtId);

		panelDatos.add(new JLabel("Nombre:"));
		txtNombre = new JTextField();
		panelDatos.add(txtNombre);

		panelDatos.add(new JLabel("Apellido:"));
		txtApellido = new JTextField();
		panelDatos.add(txtApellido);

		panelDatos.add(new JLabel("Dirección:"));
		txtDireccion = new JTextField();
		panelDatos.add(txtDireccion);

		panelDatos.add(new JLabel("DNI:"));
		txtDni = new JTextField();
		panelDatos.add(txtDni);

		panelDatos.add(new JLabel("Fecha:"));
		txtFecha = new JTextField();
		panelDatos.add(txtFecha);

		add(panelDatos, BorderLayout.NORTH);

		// Botones
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JButton btnAgregar = new JButton("Agregar");
		JButton btnActualizar = new JButton("Actualizar");
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnListar = new JButton("Listar");

		Dimension botonDimension = new Dimension(100, 30);
		btnAgregar.setPreferredSize(botonDimension);
		btnActualizar.setPreferredSize(botonDimension);
		btnEliminar.setPreferredSize(botonDimension);
		btnListar.setPreferredSize(botonDimension);

		panelBotones.add(btnAgregar);
		panelBotones.add(btnActualizar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnListar);

		add(panelBotones, BorderLayout.CENTER);

		// Área de texto para mostrar clientes
		txtAreaClientes = new JTextArea();
		txtAreaClientes.setLineWrap(true);
		txtAreaClientes.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(txtAreaClientes);
		scrollPane.setPreferredSize(new Dimension(600, 150));
		add(scrollPane, BorderLayout.SOUTH);

		// Acciones de los botones
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Convertir la fecha al formato correcto
					String fechaOriginal = txtFecha.getText();
					SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
					String fechaConvertida = formatoSalida.format(formatoEntrada.parse(fechaOriginal));

					Cliente cliente = new Cliente(Integer.parseInt(txtId.getText()), txtNombre.getText(),
							txtApellido.getText(), txtDireccion.getText(), txtDni.getText(), fechaConvertida // Usar la
																												// fecha
																												// convertida
					);
					controlador.agregarCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente agregado.");
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Usa DD/MM/YYYY.");
				}
			}
		});

		btnActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					String fechaOriginal = txtFecha.getText();
					SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
					String fechaConvertida = formatoSalida.format(formatoEntrada.parse(fechaOriginal));

					Cliente cliente = new Cliente(Integer.parseInt(txtId.getText()), txtNombre.getText(),
							txtApellido.getText(), txtDireccion.getText(), txtDni.getText(), fechaConvertida);
					controlador.actualizarCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente actualizado.");
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Usa DD/MM/YYYY.");
				}
			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				controlador.eliminarCliente(id);
				JOptionPane.showMessageDialog(null, "Cliente eliminado.");
			}
		});

		btnListar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtAreaClientes.setText(""); // Limpiar el área de texto
				String idTexto = txtId.getText().trim();
				if (!idTexto.isEmpty()) {
					try {
						int id = Integer.parseInt(idTexto);
						Cliente cliente = controlador.obtenerClientePorId(id);
						if (cliente != null) {
							txtAreaClientes.append("ID: " + cliente.getId() + "\n" + "Nombre: " + cliente.getNombre()
									+ "\n" + "Apellido: " + cliente.getApellido() + "\n" + "Dirección: "
									+ cliente.getDireccion() + "\n" + "DNI: " + cliente.getDni() + "\n" + "Fecha: "
									+ cliente.getFecha() + "\n" + "--------------------------\n");
						} else {
							JOptionPane.showMessageDialog(null, "No se encontró un cliente con la ID especificada.");
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "La ID debe ser un número válido.");
					}
				} else {
					controlador.obtenerClientes().forEach(cliente -> {
						txtAreaClientes.append("ID: " + cliente.getId() + "\n" + "Nombre: " + cliente.getNombre() + "\n"
								+ "Apellido: " + cliente.getApellido() + "\n" + "Dirección: " + cliente.getDireccion()
								+ "\n" + "DNI: " + cliente.getDni() + "\n" + "Fecha: " + cliente.getFecha() + "\n"
								+ "--------------------------\n");
					});
				}
			}
		});

	}
}
