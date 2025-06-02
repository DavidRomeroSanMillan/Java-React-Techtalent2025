package UD19.GrupalCalculadora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraDAO {

	public void guardarResultado(String operacion, double resultado) {
		String query = "INSERT INTO resultados_calculadora (operacion, resultado) VALUES (?, ?)";
		try (Connection conexion = ConexionDB.obtenerConexion();
				PreparedStatement stmt = conexion.prepareStatement(query)) {
			stmt.setString(1, operacion);
			stmt.setDouble(2, resultado);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void guardarResultadoRaiz(String operacion, double resultado) {
		String query = "INSERT INTO resultados_calculadora (operacion, resultado) VALUES (?, ?)";
		try (Connection conexion = ConexionDB.obtenerConexion();
				PreparedStatement stmt = conexion.prepareStatement(query)) {
			stmt.setString(1, operacion);
			stmt.setDouble(2, resultado);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> obtenerHistorial() {
		List<String> historial = new ArrayList<>();
		String query = "SELECT operacion, resultado FROM resultados_calculadora";

		try (Connection conexion = ConexionDB.obtenerConexion();
				Statement stmt = conexion.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				String operacion = rs.getString("operacion");
				double resultado = rs.getDouble("resultado");
				historial.add(operacion + " = " + resultado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return historial;

	}
}