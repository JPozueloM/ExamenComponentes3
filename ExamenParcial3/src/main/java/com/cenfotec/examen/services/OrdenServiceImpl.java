package com.cenfotec.examen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.examen.entities.Cliente;
import com.cenfotec.examen.entities.Orden;
import com.cenfotec.examen.repositories.ClienteRepository;
import com.cenfotec.examen.repositories.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService{
	
	@Autowired
	OrdenRepository ordenRepository;
	@Autowired
	ClienteRepository clienteRepository;


	@Override
	public List<Orden> getAllOrdenes(int count) {
		return this.ordenRepository.findAll().stream().limit(count).collect(Collectors.toList());
	}

	@Override
	public List<Orden> getAllOrdenes() {
		return this.ordenRepository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public Orden save(Orden orden) {

		if (orden.getCliente() == null) {
			Cliente cliente = clienteRepository.getById(orden.getClienteId());
			if (cliente != null) {
				orden.setCliente(cliente);
			} else {
				return null;
			}
		}
		return this.ordenRepository.save(orden);
	}

	@Override
	public Optional<Orden> getOrden(int id) {
		return this.ordenRepository.findById(id);
	}

	@Override
	public boolean deleteOrden(int id) {
		this.ordenRepository.deleteById(id);
		if (this.getOrden(id).isPresent()) {
			return false;
		} else {
			return true;
		}
	}


}
