package ar.com.flexia.cv19shared.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ar.com.flexia.cv19shared.service.*;
import ar.com.flexia.cv19shared.api.dto.NewCaso;
import ar.com.flexia.cv19shared.model.entity.Caso;
import ar.com.flexia.cv19shared.model.repository.CasoRepository;


@Service
public class CasoServiceImpl implements CasoService {
	
	private final CasoRepository repo;
		
	private PacienteService pacienteService;
	
	private UbicacionService ubicacionService;
	
	public CasoServiceImpl(CasoRepository repo, PacienteService pacienteService, UbicacionService ubicacionService) {
		super();
		this.repo = repo;
		this.pacienteService = pacienteService;
		this.ubicacionService = ubicacionService;
	}
	
	@Override
	public Caso createCaso(NewCaso newCaso) {
		
        return repo.save(new Caso(newCaso.getDeteccion(), newCaso.getCliente(),
        		ubicacionService.createUbicacion(newCaso.getUbicacion().getProvincia(), newCaso.getUbicacion().getMunicipio()),
				pacienteService.createPaciente(newCaso)));
		
	}
	
	@Override
    public Long casosEntreFechas(String fechaInicio, String fechaFin, String provincia, String municipio) {
		return repo.cantidadDeCasosPorCriteria(fechaInicio, fechaFin, provincia, municipio);
	}

	@Override
	public Page<Caso> ultimosCasos(int ultimos) {
		return repo.casosPorFecha(PageRequest.of(0, ultimos));
	}
	
	@Transactional
	@Override
	public List<Caso> findAll() {
		return repo.findAll();
	}
			
}