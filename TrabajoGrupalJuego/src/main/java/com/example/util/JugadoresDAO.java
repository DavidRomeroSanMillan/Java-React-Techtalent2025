package com.example.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadoresDAO {

	public static void insertarJugador(String nombre) {
		String sql = "INSERT INTO jugadores (nombre, victorias) VALUES (?, 0) "
				+ "ON DUPLICATE KEY UPDATE victorias = victorias";
		try (Connection conn = DBConexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nombre);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizarVictorias(String nombre) {
		String sql = "UPDATE jugadores SET victorias = victorias + 1 WHERE nombre = ?";
		try (Connection conn = DBConexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nombre);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void mostrarJugadores() {
		String sql = "SELECT * FROM jugadores";
		try (Connection conn = DBConexion.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre") + ", Victorias: "
						+ rs.getInt("victorias"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
