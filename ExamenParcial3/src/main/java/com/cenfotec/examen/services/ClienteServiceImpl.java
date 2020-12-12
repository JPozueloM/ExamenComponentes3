package com.cenfotec.examen.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.examen.entities.Cliente;
import com.cenfotec.examen.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAllClientes(int count) {
		return this.clienteRepository.findAll().stream().limit(count).collect(Collectors.toList());
	}

	@Override
	public List<Cliente> getAllClientes() {
		return this.clienteRepository.findAll().stream().collect(Collectors.toList());
		
	}
	
	@Override
	public Optional<Cliente> getCliente(int id) {
		return this.clienteRepository.findById(id);
	}
	

	@Override
	public List<Cliente> getAllClientes(String search) {
		return this.clienteRepository.findAll().stream()
				.filter(c -> (c.getPrimerApellido().toLowerCase().contains(search.toLowerCase())
						|| c.getSegundoApellido().toLowerCase().contains(search.toLowerCase())
						|| c.getDireccionFacturacion().toLowerCase().contains(search.toLowerCase())))
				.collect(Collectors.toList());
	}

	

	@Override
	public Cliente createCliente(String nombre, String primerApellido,
			String segundoApellido, String direccionHogar, String direccionFacturacion,String numeroTarjeta,int mesVencimiento,int annoVencimiento) {

		Cliente cliente = new Cliente();
		
		cliente.setNombre(nombre);
		cliente.setPrimerApellido(primerApellido);
		cliente.setSegundoApellido(segundoApellido);
		cliente.setDireccionHogar(direccionHogar);
		cliente.setDireccionFacturacion(direccionFacturacion);
		cliente.setNumeroTarjeta(numeroTarjeta);
		cliente.setMesVencimiento(mesVencimiento);
		cliente.setAnnoVencimiento(mesVencimiento);
		
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(int id, String nombre, String primerApellido,
			String segundoApellido, String direccionHogar, String direccionFacturacion,String numeroTarjeta,int mesVencimiento,int annoVencimiento) {

		Cliente cliente = clienteRepository.getById(id);

		cliente.setNombre(nombre);
		cliente.setPrimerApellido(primerApellido);
		cliente.setSegundoApellido(segundoApellido);
		cliente.setDireccionHogar(direccionHogar);
		cliente.setDireccionFacturacion(direccionFacturacion);
		cliente.setNumeroTarjeta(numeroTarjeta);
		cliente.setMesVencimiento(mesVencimiento);
		cliente.setAnnoVencimiento(mesVencimiento);

		return this.clienteRepository.save(cliente);
	}

	@Override
	public Optional<Cliente> updateCliente(int id, Cliente editar) {

		Cliente cliente = clienteRepository.getById(id);
		if (cliente != null) {
			cliente.setNombre(editar.getNombre());
			cliente.setPrimerApellido(editar.getPrimerApellido());
			cliente.setSegundoApellido(editar.getSegundoApellido());
			cliente.setDireccionHogar(editar.getDireccionHogar());
			cliente.setDireccionFacturacion(editar.getDireccionFacturacion());
			cliente.setNumeroTarjeta(editar.getNumeroTarjeta());
			cliente.setMesVencimiento(editar.getMesVencimiento());
			cliente.setAnnoVencimiento(editar.getMesVencimiento());
		
			this.clienteRepository.save(cliente);
		}
		return getCliente(id);
	}

	@Override
	public boolean deleteCliente(int id) {
		Optional<Cliente> clienteO = this.getCliente(id);
		if (clienteO.isPresent() && clienteO.get().getOrdenes().isEmpty()) {
			this.clienteRepository.delete(clienteO.get());
		} else {
			return false;
		}
		clienteO = this.getCliente(id);
		return clienteO.isEmpty();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	

}
