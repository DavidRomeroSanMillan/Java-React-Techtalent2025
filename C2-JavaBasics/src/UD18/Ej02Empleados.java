package UD18;

import java.sql.*;
import javax.swing.*;

public class Ej02Empleados {
	static Connection conexion = null;
	Statement st = null;
	static final String URL = "jdbc:mysql://localhost:3306/";
	static final String USER = "root";
	static final String PASSWORD = "";

	public static void main(String[] args) {
		crearTabla("java_empleados", "empleados",
				"(DNI VARCHAR PRIMARY KEY, Nombre VARCHAR(100), Apellidos VARCHAR(255), Departamento INT FOREIGN KEY (Departamento) REFERENCES departamentos (ID)");
		crearTabla("java_empleados", "empleados",
				"(DNI VARCHAR PRIMARY KEY, Nombre VARCHAR(100), Apellidos VARCHAR(255), Departamento INT FOREIGN KEY (Departamento) REFERENCES departamentos (ID)");

	}

	public static void crearTabla(String db, String nombre, String contenido) {
		try {
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexión exitosa a la base de datos");
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + nombre + "" + contenido;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al crear la tabla.");
		}
	}
}
