package com.challenge.disney.servicios;

import com.challenge.disney.dtos.PeliculaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PeliculaServicio {
    List<PeliculaDTO> gelAll();
    ResponseEntity<Object> nuevaPelicula(PeliculaDTO peliculaDTO);
    ResponseEntity<Object> modificarPelicula (long id,PeliculaDTO peliculaDTO);
    ResponseEntity<Object> eliminarPelicula (long id)throws Exception;
    List<PeliculaDTO> buscarPelicula(String campo, String param);
    ResponseEntity<Object> agregarPersonajeAPelicula(long idMovie, long idCharacter);
    ResponseEntity<Object> eliminarPersonajeAPelicula(long idMovie, long idCharacter);

}
