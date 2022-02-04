package ar.com.flexia.cv19shared.service;

import ar.com.flexia.cv19shared.api.dto.*;
import ar.com.flexia.cv19shared.model.entity.*;


public interface PacienteService {

	Paciente createPaciente(NewCaso newCaso);
	
}