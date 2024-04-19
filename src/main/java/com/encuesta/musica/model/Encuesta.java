package com.encuesta.musica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

import com.encuesta.musica.dto.EncuestaDTO;
import com.fasterxml.jackson.annotation.JsonValue;

@Entity
public class Encuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String correo;
	//@JsonValue
	private String generoMusical;
	
	public Encuesta() {
		
	}
	
	public Encuesta(@Valid EncuestaDTO encuestaRequest) {
		this.correo = encuestaRequest.getCorreo();
		this.generoMusical = encuestaRequest.getGeneroMusical();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getGeneroMusical() {
		return generoMusical;
	}
	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}
	
}
