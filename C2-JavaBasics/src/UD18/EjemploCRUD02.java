package UD18;

import java.sql.*;

public class EjemploCRUD02 {
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/meteo";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        try {
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");

            // Crear un objeto Statement para ejecutar consultas SQL
            statement = conexion.createStatement();

            // Insertar 3 registros en la tabla 'estacion'
//            statement.executeUpdate("INSERT INTO estacion (lat, longitud, alt) VALUES ('41.5', '1.1', 69)");
//            statement.executeUpdate("INSERT INTO estacion (lat, longitud, alt) VALUES ('21', '4.8', 120)");
//            statement.executeUpdate("INSERT INTO estacion (lat, longitud, alt) VALUES ('41.9', '3.2', 176)");


            // Actualizar el nombre de un registro en la tabla 'estacion'
//            statement.executeUpdate("UPDATE estacion SET lat = '41.3' WHERE id = 1");

//            // Eliminar un registro específico de la tabla 'estacion'
//            statement.executeUpdate("DELETE FROM estacion WHERE id = 1");
//
//            // Consultar y mostrar los registros de la tabla 'estacion'
            ResultSet resultSet = statement.executeQuery("SELECT * FROM estacion");
            System.out.println("Registros en la tabla 'estacion':");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", latitud: " 
            + resultSet.getString("lat") + ", longitud: " +resultSet.getString("longitud")
            +", altitud: "+resultSet.getInt("alt"));
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}