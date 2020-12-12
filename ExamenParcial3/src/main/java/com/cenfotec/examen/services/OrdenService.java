package com.cenfotec.examen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cenfotec.examen.entities.Orden;

public interface OrdenService {
	public List<Orden> getAllOrdenes(int limit);

	public List<Orden> getAllOrdenes();

	public Orden save(Orden orden);

	public Optional<Orden> getOrden(int id);

	public boolean deleteOrden(int id);


}
