
package UD19.GrupalCalculadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	private static final String URL = "jdbc:mysql://localhost:3306/calculadora";
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "";

	public static Connection obtenerConexion() throws SQLException {
		return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
	}
}
