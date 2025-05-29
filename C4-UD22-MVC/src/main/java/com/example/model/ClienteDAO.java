package com.example.model;

import com.example.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

	public void agregarCliente(Cliente cliente) {
		String sql = "INSERT INTO clientes (id, nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, cliente.getId());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getApellido());
			stmt.setString(4, cliente.getDireccion());
			stmt.setString(5, cliente.getDni());
			stmt.setString(6, cliente.getFecha());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> obtenerClientes() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM clientes";

		try (Connection conn = ConexionDB.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("direccion"), rs.getString("dni"), rs.getString("fecha"));
				clientes.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return clientes;
	}

	public void actualizarCliente(Cliente cliente) {
		String sql = "UPDATE clientes SET nombre = ?, apellido = ?, direccion = ?, dni = ?, fecha = ? WHERE id = ?";
		try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getApellido());
			stmt.setString(3, cliente.getDireccion());
			stmt.setString(4, cliente.getDni());
			stmt.setString(5, cliente.getFecha());
			stmt.setInt(6, cliente.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarCliente(int id) {
		String sql = "DELETE FROM clientes WHERE id = ?";
		try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
