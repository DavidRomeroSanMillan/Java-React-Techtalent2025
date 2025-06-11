package com.example.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JugadoresDAO {

	public void insertarJugador(String nombre, String contraseña) {
		String sqlSelect = "SELECT contraseña FROM jugadores WHERE nombre = ?";
		String sqlInsert = "INSERT INTO jugadores (nombre, victorias, contraseña) VALUES (?, 0, ?)";

		try (Connection conn = DBConexion.getConnection();
				PreparedStatement selectStmt = conn.prepareStatement(sqlSelect)) {

			// Verificar si el jugador ya existe
			selectStmt.setString(1, nombre);
			try (ResultSet rs = selectStmt.executeQuery()) {
				if (rs.next()) {
					// Si el jugador existe, verificar la contraseña
					String contraseñaAlmacenada = rs.getString("contraseña");
					if (!contraseñaAlmacenada.equals(hashContraseña(contraseña))) {
						throw new IllegalArgumentException("La contraseña no coincide para el jugador: " + nombre);
					}
					return; // Si la contraseña coincide, no es necesario insertar
				}
			}

			// Si el jugador no existe, insertar un nuevo registro
			try (PreparedStatement insertStmt = conn.prepareStatement(sqlInsert)) {
				insertStmt.setString(1, nombre);
				insertStmt.setString(2, hashContraseña(contraseña));
				insertStmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al interactuar con la base de datos", e);
		}
	}

	private String hashContraseña(String contraseña) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(contraseña.getBytes());
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				hexString.append(String.format("%02x", b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error al hashear la contraseña", e);
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

	public boolean verificarContraseña(String nombre, String contraseña) {
		String sql = "SELECT contraseña FROM jugadores WHERE nombre = ?";
		try (Connection conn = DBConexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nombre);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					String contraseñaAlmacenada = rs.getString("contraseña");
					return contraseñaAlmacenada.equals(hashContraseña(contraseña));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
