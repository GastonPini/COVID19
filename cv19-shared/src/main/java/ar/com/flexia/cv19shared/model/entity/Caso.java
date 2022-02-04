package ar.com.flexia.cv19shared.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Caso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_caso")
	private Long id;
	
	private LocalDate deteccion;
	
	private String cliente;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Ubicacion ubicacion;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Paciente paciente;
	
	public Caso() {}
	
	public Caso(LocalDate deteccion, String cliente, Ubicacion ubicacion, Paciente paciente) {
		super();
		this.deteccion = deteccion;
		this.cliente = cliente;
		this.ubicacion = ubicacion;
		this.paciente = paciente;
	}
	
	public Long getId() {
		return id;
	}
	
	public LocalDate getDeteccion() {
		return this.deteccion;
	}
	
	///////////////////// SECCIÓN CLIENT /////////////////////
	
	public String getCliente() {
		return this.cliente;
	}

	///////////////////// SECCIÓN PATIENT /////////////////////

	public Paciente getPaciente() {
		return this.paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	///////////////////// SECCIÓN UBICACIÓN /////////////////////
	
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}