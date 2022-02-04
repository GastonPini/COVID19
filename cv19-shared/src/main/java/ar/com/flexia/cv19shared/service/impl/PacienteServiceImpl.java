package ar.com.flexia.cv19shared.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.flexia.cv19shared.api.dto.*;
import ar.com.flexia.cv19shared.model.entity.*;
import ar.com.flexia.cv19shared.model.repository.*;
import ar.com.flexia.cv19shared.service.*;


@Service
public class PacienteServiceImpl implements PacienteService {
	
	private final PacienteRepository repo;
	
	public PacienteServiceImpl(PacienteRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public Paciente createPaciente(NewCaso newCaso) {
	
		Optional<Paciente> p = repo.findByDni(newCaso.getPaciente().getDni());

        if (p.isPresent())
            return p.get();
        
        else
        	return repo.save(new Paciente(newCaso.getPaciente().getNombre(), newCaso.getPaciente().getApellido(), newCaso.getPaciente().getDni(),newCaso.getPaciente().getNacimiento(), newCaso.getPaciente().getTelefono(), newCaso.getPaciente().getEmail()));
		
	}

}