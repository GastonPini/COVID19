package ar.com.flexia.cv19shared.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(
	uniqueConstraints = {
		@UniqueConstraint( name = "UC_DNI", columnNames = { "dni" } ),
		@UniqueConstraint( name = "UC_PACIENTE", columnNames = { "nombre", "apellido", "dni" } )
	}
	
)
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private String dni;
	
	private LocalDate nacimiento;
	
	private Long telefono;
	
	private String email;
		
	public Paciente() {}
	
	public Paciente(String nombre, String apellido, String dni, LocalDate nacimiento, Long telefono, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nacimiento = nacimiento;
		this.telefono = telefono;
		this.email = email;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}