package ar.com.flexia.cv19query.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.flexia.cv19shared.model.entity.*;
import ar.com.flexia.cv19shared.service.*;
import ar.com.flexia.cv19shared.model.repository.*;


@RestController
@RequestMapping(path = "/caso")
public class CasoController {

	private CasoRepository repo;
	private CasoService service;
	
	public CasoController(CasoRepository repo, CasoService service) {
		super();
		this.repo = repo;
		this.service = service;
	}

	@Secured({"ADMIN"})
    @GetMapping
    public List<Caso> ultimosCasos(@RequestParam(name = "Cantidad-casos", required = false) Integer cantidadCasos) {
        Page<Caso> page = service.ultimosCasos(cantidadCasos);
        return page.getContent();
    }

    @Secured({"ADMIN"})
    @GetMapping(path = "/cantidad")
    public Long cantidadCasos(@RequestParam(name = "Fecha-inicio", required = false) String fechaInicio,
    						 @RequestParam(name = "Fecha-fin", required = false) String fechaFin,
    						 @RequestParam(name = "Provincia", required = false) String provincia,
    						 @RequestParam(name = "Municipio", required = false) String municipio) {
    	
    	return repo.cantidadDeCasosPorCriteria(fechaInicio, fechaFin, provincia, municipio);
    	
    }
			
}