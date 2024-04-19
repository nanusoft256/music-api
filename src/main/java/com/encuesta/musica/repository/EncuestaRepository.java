package com.encuesta.musica.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import com.encuesta.musica.model.Encuesta;

public interface EncuestaRepository extends CrudRepository<Encuesta, Integer>{

	List<Encuesta> findAll(Specification<Encuesta> specification);

}
