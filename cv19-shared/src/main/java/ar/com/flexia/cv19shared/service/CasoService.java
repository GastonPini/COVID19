package ar.com.flexia.cv19shared.service;

import ar.com.flexia.cv19shared.api.dto.*;
import ar.com.flexia.cv19shared.model.entity.*;

import java.util.List;

import org.springframework.data.domain.Page;


public interface CasoService {

	public Caso createCaso(NewCaso newCaso);
	
	Long casosEntreFechas(String fechaInicio, String fechaFin, String provincia, String municipio);
	
	Page<Caso> ultimosCasos(int cantidad);
	
	public List<Caso> findAll();
    
}