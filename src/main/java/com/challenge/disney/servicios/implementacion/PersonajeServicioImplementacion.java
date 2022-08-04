package com.challenge.disney.servicios.implementacion;

import com.challenge.disney.dtos.PersonajeDTO;
import com.challenge.disney.modelos.Personaje;
import com.challenge.disney.modelos.PersonajePelicula;
import com.challenge.disney.repositorios.PersonajePeliculaRepositorio;
import com.challenge.disney.repositorios.PersonajeRepositorio;
import com.challenge.disney.servicios.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class PersonajeServicioImplementacion implements PersonajeServicio {
    @Autowired
    private PersonajeRepositorio personajeRepositorio;
    @Autowired
    private PersonajePeliculaRepositorio personajePeliculaRepositorio;

    @Override
    public List<PersonajeDTO> getAll() {
        return personajeRepositorio.findAll().stream().map(PersonajeDTO::new).collect(Collectors.toList());
    }
    @Override
    public PersonajeDTO getPersonajeDTOById(long id) {
        Personaje personaje = personajeRepositorio.findById(id).orElse(null);
        return new PersonajeDTO(personaje);
    }

    @Override
    public Personaje getPersonajeById(long id) {
        return personajeRepositorio.findById(id).orElse(null);
    }

    @Override
    public Personaje findByName(String nombre) {
        return personajeRepositorio.findByNombre(nombre);
    }

    @Override
    public void savePersonaje(Personaje personaje) {
        personajeRepositorio.save(personaje);
    }

    @Override
    public ResponseEntity<Object> nuevoPersonaje(PersonajeDTO personajeDTO) {
        if( personajeDTO.getImagen().isBlank() ||
            personajeDTO.getNombre().isBlank() ||
            personajeDTO.getHistoria().isBlank() ||
            String.valueOf(personajeDTO.getEdad()).isBlank() ||
            String.valueOf(personajeDTO.getPeso()).isBlank()){
            return ResponseEntity.badRequest().build();
        }
        Personaje personaje = new Personaje(personajeDTO.getImagen(), personajeDTO.getNombre(), personajeDTO.getHistoria(), personajeDTO.getEdad(), personajeDTO.getPeso());
        personajeRepositorio.save(personaje);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<Object> modificarPersonaje(long id, PersonajeDTO personajeDTO) {
        Personaje personaje = personajeRepositorio.findById(id).orElse(null);
        if(personaje == null){
            return ResponseEntity.badRequest().body("Personaje Inexistente");
        }
        if(!personajeDTO.getImagen().isBlank()){
            personaje.setImagen(personajeDTO.getImagen());
        }
        if(!personajeDTO.getNombre().isBlank()){
            personaje.setNombre(personajeDTO.getNombre());
        }
        if(!personajeDTO.getHistoria().isBlank()){
            personaje.setHistoria(personajeDTO.getHistoria());
        }
        if(personajeDTO.getEdad() > 0){
            personaje.setEdad(personajeDTO.getEdad());
        }
        if(personajeDTO.getPeso() > 0){
            personaje.setPeso(personajeDTO.getPeso());
        }
        personajeRepositorio.save(personaje);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<Object> eliminarPersonaje(long id) {
        Personaje personaje = personajeRepositorio.findById(id).orElse(null);
        if(personaje == null){
            return ResponseEntity.badRequest().body("Personaje Inexistente");
        }
        if(personaje.getPersonajePeliculas().size()>0){
            personaje.getPersonajePeliculas().forEach(element -> {
                personajePeliculaRepositorio.deleteById(element.getId());
            });
        }
        personajeRepositorio.deleteById(id);
        return ResponseEntity.accepted().body("Personaje eliminado");
    }
}
