
package com.example.controller;

import com.example.model.Cliente;
import com.example.model.ClienteDAO;

import java.util.List;

public class Controlador {
	private ClienteDAO clienteDAO;
    private List<Cliente> listaClientes;

	public Controlador() {
	    this.clienteDAO = new ClienteDAO();
	    listaClientes = clienteDAO.obtenerClientes();
	}

	public void agregarCliente(Cliente cliente) {
		clienteDAO.agregarCliente(cliente);
	}

	public List<Cliente> obtenerClientes() {
		return clienteDAO.obtenerClientes();
	}
	public Cliente obtenerClientePorId(int id) {
	    if (listaClientes.isEmpty()) {
	        System.out.println("La lista de clientes está vacía.");
	        return null;
	    }
	    for (Cliente cliente : listaClientes) {
	        System.out.println("Comparando ID: " + cliente.getId() + " con " + id);
	        if (cliente.getId() == id) {
	            return cliente;
	        }
	    }
	    System.out.println("No se encontró un cliente con la ID especificada.");
	    return null;
	}
	public void actualizarCliente(Cliente cliente) {
		clienteDAO.actualizarCliente(cliente);
	}

	public void eliminarCliente(int id) {
		clienteDAO.eliminarCliente(id);
	}
}
