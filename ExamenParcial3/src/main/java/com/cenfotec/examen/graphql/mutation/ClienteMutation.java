package com.cenfotec.examen.graphql.mutation;

import com.cenfotec.examen.entities.Cliente;
import com.cenfotec.examen.services.ClienteServiceImpl;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMutation implements GraphQLMutationResolver{
	
	@Autowired 
	private ClienteServiceImpl clienteServiceImpl;
	
	public Cliente createCliente(String nombre, String primerApellido,
			String segundoApellido, String direccionHogar, String direccionFacturacion,String numeroTarjeta, int mesVencimiento,int annoVencimiento) {
		return this.clienteServiceImpl.createCliente(nombre, primerApellido,
			segundoApellido, direccionHogar, direccionFacturacion, numeroTarjeta,  mesVencimiento, annoVencimiento);
		
	}
	public Cliente updateCliente(int id, String nombre, String primerApellido,
			String segundoApellido, String direccionHogar, String direccionFacturacion,String numeroTarjeta, int mesVencimiento,int annoVencimiento) {
		return this.clienteServiceImpl.updateCliente(id,nombre, primerApellido,
			segundoApellido, direccionHogar, direccionFacturacion, numeroTarjeta,  mesVencimiento, annoVencimiento);
	}
	
	public boolean deleteCliente(int id) {
		return this.clienteServiceImpl.deleteCliente(id);
	}


}

