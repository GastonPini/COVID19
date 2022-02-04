package ar.com.flexia.cv19shared.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.flexia.cv19shared.model.entity.*;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	public Optional<Paciente> findByDni(String dni);

}