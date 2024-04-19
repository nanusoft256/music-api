package com.encuesta.musica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.encuesta.musica.dto.CantTipoMusicaDTO;
import com.encuesta.musica.dto.EncuestaDTO;
import com.encuesta.musica.model.Encuesta;
import com.encuesta.musica.service.EncuestaService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EncuestaController {

	@Autowired 
	EncuestaService encuestaService;
	
	@GetMapping("/encuestas")
	public ResponseEntity<List<Encuesta>> consultaEncuestas() {
		
		List<Encuesta> response = encuestaService.obtenerEncuestas();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/cantidad-por-genero-musical")
	public ResponseEntity<Object> cantidadTiposDeMusica() {
		
		CantTipoMusicaDTO response = encuestaService.cantidadTiposDeMusica();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "encuestas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Encuesta> agregarEncuestas(
			@Valid @RequestBody EncuestaDTO encuestaRequest){
		Encuesta encuesta = new Encuesta(encuestaRequest);
		Encuesta nuevaEncuesta = encuestaService.agregarEncuestas(encuesta); 
		return new ResponseEntity<>(nuevaEncuesta, HttpStatus.CREATED);
	}
	
}
