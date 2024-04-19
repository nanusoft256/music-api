package com.encuesta.musica.controller;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.encuesta.musica.dto.EncuestaDTO;
import com.encuesta.musica.model.Encuesta;
import com.encuesta.musica.service.EncuestaService;


class EncuestaControllerTest {

	@InjectMocks
	EncuestaController encuestaController;
	
	@Mock
	private EncuestaService service;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void insertarEncuestaTest() {
		
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		EncuestaDTO encuestaDTO = new EncuestaDTO();
		encuestaDTO.setCorreo("prueba1@gmail.com");
		encuestaDTO.setGeneroMusical("ROCK");
		Encuesta encuesta = new Encuesta(encuestaDTO);
		
		when(service.agregarEncuestas(any(Encuesta.class))).thenReturn(encuesta);
		
		ResponseEntity<Encuesta> respuesta = encuestaController.agregarEncuestas(encuestaDTO);
		
		assertThat(respuesta.getStatusCodeValue()).isEqualTo(201);
		
		assertThat(respuesta.getBody().getCorreo()).isEqualTo(encuestaDTO.getCorreo());
		
		assertThat(respuesta.getBody().getGeneroMusical()).isEqualTo(encuestaDTO.getGeneroMusical());
		
	}
	
	@Test
	void getEncuestasTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		List<Encuesta> encuestas = new ArrayList<>();
		when(service.obtenerEncuestas()).thenReturn(encuestas);
		ResponseEntity<List<Encuesta>> respuesta = encuestaController.consultaEncuestas();
		assertTrue(encuestas.isEmpty());
		assertThat(respuesta.getStatusCodeValue()).isEqualTo(200);
	}
}
