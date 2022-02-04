package ar.com.flexia.cv19shared.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.flexia.cv19shared.model.entity.*;


@Repository
public interface CasoRepository extends JpaRepository<Caso, Long>, CasoCustomRepository {
	
    @Query("SELECT c FROM Caso c ORDER BY c.deteccion DESC")
    Page<Caso> casosPorFecha(Pageable pageable);
	
}