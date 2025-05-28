package com.example.model;

import com.example.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public void agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (id, nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
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
}