package ar.com.flexia.cv19shared.model.repository.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import ar.com.flexia.cv19shared.model.entity.Caso;
import ar.com.flexia.cv19shared.model.entity.Ubicacion;
import ar.com.flexia.cv19shared.model.repository.CasoCustomRepository;


@Repository
public class CasoCustomRepositoryImpl implements CasoCustomRepository {

	private EntityManager em;
	
	public CasoCustomRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public Long cantidadDeCasosPorCriteria(String fechaDesde, String fechaHasta, String provincia,
			String municipio) {
	
		CriteriaBuilder cb = em.getCriteriaBuilder();
	
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		
		Root<Caso> caso = cq.from(Caso.class);
		
		Path<Ubicacion> ubi = caso.get("ubicacion");
		
		List<Predicate> p = new ArrayList<>();
		
		if(!ObjectUtils.isEmpty(provincia))
			p.add(cb.like(ubi.get("provincia"), "%" + provincia + "%"));
		
		if(!ObjectUtils.isEmpty(municipio))
			p.add(cb.like(ubi.get("municipio"), "%" + municipio + "%"));
		
		if(!ObjectUtils.isEmpty(fechaDesde)) {
			
			LocalDate fechaInicio = LocalDate.parse(fechaDesde);
			LocalDate fechaFin = null;
			
			 if(!ObjectUtils.isEmpty(fechaHasta))
				 fechaFin = LocalDate.parse(fechaHasta);
			 else
				 fechaFin = LocalDate.now();
		
			 p.add(cb.between(caso.get("deteccion"), fechaInicio, fechaFin));
			 
		}
		
		cq.select(cb.count(caso));
		
		cq.where(p.toArray(new Predicate[0]));
		
		return em.createQuery(cq).getSingleResult();
		
	}
	
}
