package com.cenfotec.examen.graphql.query;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.examen.services.ClienteService;
import com.cenfotec.examen.services.ClienteServiceImpl;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.cenfotec.examen.entities.Cliente;

@Component
public class ClienteQuery implements  GraphQLQueryResolver{
	
	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	public List<Cliente> getClientes(int count){
		return this.clienteServiceImpl.getAllClientes(count);
	}
	
	public Optional<Cliente> getCliente(int id){
		return this.clienteServiceImpl.getCliente(id);
	}
	
	public List<Cliente> getClientesSearch(String search){
		return this.clienteServiceImpl.getAllClientes(search);
	}
	
	public List<Cliente> getClientes(){
		return this.clienteServiceImpl.getAllClientes();
	}


}
