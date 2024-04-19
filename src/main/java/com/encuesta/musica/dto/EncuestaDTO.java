package com.encuesta.musica.dto;

import javax.validation.constraints.NotEmpty;

public class EncuestaDTO {
	
	@NotEmpty
	private String correo;
	@NotEmpty
	private String generoMusical;
	
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
