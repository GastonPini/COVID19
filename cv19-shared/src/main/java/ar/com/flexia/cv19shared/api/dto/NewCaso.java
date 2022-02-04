package ar.com.flexia.cv19shared.api.dto;

import java.time.LocalDate;

import ar.com.flexia.cv19shared.model.entity.*;


public class NewCaso {
	
	private LocalDate deteccion;
	
	public String cliente;
	
	private Ubicacion ubicacion;
	
	public Paciente paciente;
	
	public NewCaso() {
		super();
	}
	
	public LocalDate getDeteccion() {
		return deteccion;
	}
	
	public String getCliente() {
		return cliente;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Paciente getPaciente() {
		return paciente;
	}
	
}