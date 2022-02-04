package ar.com.flexia.cv19shared.model.entity;

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
		@UniqueConstraint(name = "UC_PROVINCIA_MUNICIPIO", columnNames = { "provincia", "municipio" })
	}
)
public class Ubicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ubicacion")
	private Long id;
	
	private String provincia;
	
	private String municipio;
	
	public Ubicacion() {}

	public Ubicacion(String provincia, String municipio) {
		super();
		this.provincia = provincia;
		this.municipio = municipio;
	}
	
	@JsonIgnore
	public Long getId() {
		return this.id;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public String getMunicipio() {
		return this.municipio;
	}
	
}