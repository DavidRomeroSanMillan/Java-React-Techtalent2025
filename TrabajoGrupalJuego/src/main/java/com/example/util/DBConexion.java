package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexion {
	private static final String URL = "jdbc:mysql://localhost:3306/hundir_flota";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
