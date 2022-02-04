package ar.com.flexia.cv19load.api.controller;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.flexia.cv19shared.api.dto.NewCaso;
import ar.com.flexia.cv19shared.model.entity.Caso;
import ar.com.flexia.cv19shared.service.CasoService;


@RestController
@RequestMapping(path = "/caso")
public class CasoController {

	private CasoService service;
	
	public CasoController(CasoService service) {
		super();
		this.service = service;
	}
	
	@Secured({"CLIENT"})
	@PostMapping
	public Caso createCaso(@RequestBody NewCaso request) {
		return service.createCaso(request);		
	}

	// Prueba de seguridad (se hace accesible al habilitar GET en SecurityConfig)
	@Secured({"ADMIN"})
	@GetMapping
	public List<Caso> getCasos() {
		return service.findAll();
	}
			
}