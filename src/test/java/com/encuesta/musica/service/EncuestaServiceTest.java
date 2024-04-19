package com.encuesta.musica.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.encuesta.musica.dto.EncuestaDTO;
import com.encuesta.musica.model.Encuesta;
import com.encuesta.musica.repository.EncuestaRepository;

class EncuestaServiceTest {

	@InjectMocks
	EncuestaServiceImpl service;
	
	@Mock
	EncuestaRepository encuestaRepository;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void insertarEncuestaTest() {
		
		EncuestaDTO encuestaDTO = new EncuestaDTO();
		encuestaDTO.setCorreo("pruebaServicio@gmail.com");
		encuestaDTO.setGeneroMusical("POP");
		Encuesta encuesta = new Encuesta(encuestaDTO);
		when(encuestaRepository.save(any(Encuesta.class))).thenReturn(encuesta);
	
		Encuesta response = service.agregarEncuestas(encuesta);
		
		assertEquals("POP", response.getGeneroMusical());
		
		assertEquals("pruebaServicio@gmail.com", response.getCorreo());
		
		
	}
	
	@Test
	void listarEncuestasTest() {
		List<Encuesta> lista = new ArrayList<>();
		when(encuestaRepository.findAll()).thenReturn(lista);
		List<Encuesta> response = service.obtenerEncuestas();
		assertTrue(response.isEmpty());
		
	}
	
	
	
}
