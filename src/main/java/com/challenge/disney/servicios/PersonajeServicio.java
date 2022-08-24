package com.challenge.disney.servicios;

import com.challenge.disney.dtos.PersonajeDTO;
import com.challenge.disney.modelos.Personaje;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonajeServicio {
    List<PersonajeDTO> getAll();
    PersonajeDTO getPersonajeDTOById(long id);
    Personaje getPersonajeById(long id);
    Personaje findByName(String nombre);
    void savePersonaje(Personaje personaje);
    ResponseEntity<Object> nuevoPersonaje(PersonajeDTO personajeDTO);
    ResponseEntity<Object> modificarPersonaje (long id, PersonajeDTO personajeDTO);
    ResponseEntity<Object> eliminarPersonaje (long id);
    ResponseEntity<?> buscarPersonaje (String campo, String name);
}
