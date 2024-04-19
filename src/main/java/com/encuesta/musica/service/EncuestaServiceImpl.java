package com.encuesta.musica.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.encuesta.musica.dto.CantTipoMusicaDTO;
import com.encuesta.musica.model.Encuesta;
import com.encuesta.musica.repository.EncuestaRepository;

@Service
public class EncuestaServiceImpl implements EncuestaService{

	@Autowired
	EncuestaRepository encuestaRepository;
	
	@Override
	public List<Encuesta> obtenerEncuestas() {
		Iterable<Encuesta> iter = encuestaRepository.findAll();
		List<Encuesta> result = new ArrayList<>();
		iter.forEach(result::add); 
		return result;
	}
	
	@Override
	public Encuesta agregarEncuestas(Encuesta encuesta) {
		return encuestaRepository.save(encuesta);
	}
	
	@Override
	public CantTipoMusicaDTO cantidadTiposDeMusica(){
		CantTipoMusicaDTO cantTipoMusicaDTO = new CantTipoMusicaDTO();
		int rock = findByCriteria("ROCK").size();
		int pop = findByCriteria("POP").size();
		int jazz = findByCriteria("JAZZ").size();
		int clasica = findByCriteria("CLASICA").size();
		cantTipoMusicaDTO.setCantTipoROCK(rock);
		cantTipoMusicaDTO.setCantTipoPOP(pop);
		cantTipoMusicaDTO.setCantTipoJAZZ(jazz);
		cantTipoMusicaDTO.setCantTipoCLASICA(clasica);
		return cantTipoMusicaDTO;
		
	}
	
	public List<Encuesta> findByCriteria(String generoMusical) {

        return encuestaRepository.findAll(new Specification<Encuesta>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Encuesta> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if(generoMusical != null) {
                    
                    predicates.add(criteriaBuilder.equal(
                    	    criteriaBuilder.upper(root.get("generoMusical")), 
                    	    generoMusical.toUpperCase()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }
	
	

}
