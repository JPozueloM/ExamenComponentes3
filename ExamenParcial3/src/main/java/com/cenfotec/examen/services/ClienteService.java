package com.cenfotec.examen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cenfotec.examen.entities.Cliente;
import com.cenfotec.examen.repositories.ClienteRepository;

public interface ClienteService {
	
	public List<Cliente> getAllClientes(int count);

	public List<Cliente> getAllClientes();

	public List<Cliente> getAllClientes(String buscar);
	
	public Optional<Cliente> getCliente(int id);

	public Cliente createCliente(String nombre, String primerApellido,
			String segundoApellido, String direccionHogar, String direccionFacturacion,String numeroTarjeta, int mesVencimiento,int annoVencimiento);

	public Cliente save(Cliente cliente);

	public boolean deleteCliente(int id);

	public Cliente updateCliente(int id, String nombre, String primerApellido,
			String segundoApellido, String direccionHogar, String direccionFacturacion,String numeroTarjeta, int mesVencimiento,int annoVencimiento);

	public Optional<Cliente> updateCliente(int id, Cliente editar);


}
