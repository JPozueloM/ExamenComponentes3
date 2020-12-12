package com.cenfotec.examen.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	 @Id
	 @Column(name = "ID", nullable = false)
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 
	 @Column(name = "nombre", nullable = false)
	 private String nombre;
	 
	 @Column(name = "primerApellido", nullable = false)
	 private String primerApellido;
	 
	 @Column(name = "segundoApellido", nullable = false)
	 private String segundoApellido;
	 
	 @Column(name = "direccionHogar")
	 private String direccionHogar;
	 
	 @Column(name = "direccionFacturacion")
	 private String direccionFacturacion;
	 
	 @Column(name = "numeroTarjeta")
	 private String numeroTarjeta;
	 
	 @Column(name = "mesVencimiento")
	 private int mesVencimiento;
	 
	 @Column(name = "annoVencimiento")
	 private int annoVencimiento;
	 
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	private List<Orden> ordenes;
	 
	
	}


