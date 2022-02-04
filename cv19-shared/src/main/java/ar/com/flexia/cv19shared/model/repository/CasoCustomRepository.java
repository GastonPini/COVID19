package ar.com.flexia.cv19shared.model.repository;

import org.springframework.stereotype.Repository;


@Repository
public interface CasoCustomRepository {
    
    public Long cantidadDeCasosPorCriteria(String fechaDesde, String fechaHasta, String provincia, String municipio);
    
}