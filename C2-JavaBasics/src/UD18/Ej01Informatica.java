package UD18;

import java.sql.*;

import javax.swing.*;

public class Ej01Informatica {
	static Connection conexion = null;
	Statement st = null;
	static final String URL = "jdbc:mysql://localhost:3306/meteo";
	static final String USER = "root";
	static final String PASSWORD = "";

	public static void main(String[] args) {
//		crearTabla("java_informatica", "fabricantes", "(ID INT PRIMARY KEY, Nombre VARCHAR(100)");
//		crearTabla("java_informatica", "articulos", "(ID INT PRIMARY KEY, Nombre VARCHAR(100), Precio INT, \"\r\n"
//				+ "					+ \"Fabricante INT, FOREIGN KEY (Fabricante) REFERENCES fabricantes(ID))");
//		insertarDatos("java_informatica", "fabricantes", "ID, Nombre", "1011, 'Flores Maripili'");
//		insertarDatos("java_informatica", "fabricantes", "ID, Nombre", "1020, 'Recambios Manolo'");
//		insertarDatos("java_informatica", "fabricantes", "ID, Nombre", "2033, 'Ferretería Sanjuan'");
//		insertarDatos("java_informatica", "fabricantes", "ID, Nombre", "2032, 'Piezas Juan Carlos'");
//		insertarDatos("java_informatica", "fabricantes", "ID, Nombre", "1056, 'Laminados Bou'");
		insertarDatos("java_informatica", "articulos", "ID, Nombre, Precio, Fabricante", "91, 'Ordenador HP', 200, 1020");



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

	public static void insertarDatos(String db, String nombre_tabla, String Values, String QueryValues) {
		try {
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexión exitosa a la base de datos");
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + nombre_tabla + "(" + Values + ")" + " VALUES(" + QueryValues +");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos almacenados correctamente.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error de almacenamiento.");

		}
	}
}
