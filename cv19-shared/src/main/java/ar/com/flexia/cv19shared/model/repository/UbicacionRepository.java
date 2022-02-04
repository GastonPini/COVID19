package ar.com.flexia.cv19shared.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.flexia.cv19shared.model.entity.*;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {

	Optional<Ubicacion> findByProvinciaAndMunicipio(String provincia, String municipio);
	
}