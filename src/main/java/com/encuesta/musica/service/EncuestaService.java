package com.encuesta.musica.service;

import java.util.List;

import com.encuesta.musica.dto.CantTipoMusicaDTO;
import com.encuesta.musica.model.Encuesta;

public interface EncuestaService {
	List <Encuesta> obtenerEncuestas();

	Encuesta agregarEncuestas(Encuesta encuesta);

	CantTipoMusicaDTO cantidadTiposDeMusica();
}
