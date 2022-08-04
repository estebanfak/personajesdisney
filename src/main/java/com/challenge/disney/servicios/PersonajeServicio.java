package com.challenge.disney.servicios;

import com.challenge.disney.dtos.PersonajeDTO;
import com.challenge.disney.modelos.Personaje;
import com.sun.istack.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
}
