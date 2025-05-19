
package UD18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ej00CreateDB {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/";
		String password = "";
		String user = "root";

		String sqlCreateDB = "CREATE DATABASE IF NOT EXISTS java_informatica";

		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement()) {

			statement.executeUpdate(sqlCreateDB);
			System.out.println("Base de datos creada.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
