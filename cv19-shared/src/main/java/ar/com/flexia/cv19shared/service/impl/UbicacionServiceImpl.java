package ar.com.flexia.cv19shared.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.flexia.cv19shared.model.entity.*;
import ar.com.flexia.cv19shared.model.repository.*;
import ar.com.flexia.cv19shared.service.*;


@Service
public class UbicacionServiceImpl implements UbicacionService {
	
	private final UbicacionRepository repo;
	
	public UbicacionServiceImpl(UbicacionRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
    public Ubicacion createUbicacion(String provincia, String municipio) {
        
    	Optional<Ubicacion> u = repo.findByProvinciaAndMunicipio(provincia, municipio);

        if (u.isPresent())
            return u.get();
        
        else
            return repo.save(new Ubicacion(provincia, municipio));

	}
	
}