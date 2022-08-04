package com.challenge.disney.controladores;

import com.challenge.disney.dtos.PersonajeDTO;
import com.challenge.disney.modelos.Personaje;
import com.challenge.disney.servicios.PersonajeServicio;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/api")
public class PersonajeControlador {
    @Autowired
    private PersonajeServicio personajeServicio;
//----------------------------------------Obtener todos los personajes--------------------------------------------------
    @GetMapping("/personajes")
    public List<PersonajeDTO> getAll(){
        return personajeServicio.getAll();
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Obtener un personaje por id---------------------------------------------------
    @GetMapping("/personajes/{id}")
    public PersonajeDTO getPersonaje(@PathVariable Long id) {
        return personajeServicio.getPersonajeDTOById(id);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Crear nuevo personaje---------------------------------------------------------
    @PostMapping("/personajes")   // TODO --> PERSONaje como objeto  jeropaaa
    public ResponseEntity<Object> nuevoPersonaje(@RequestBody(required = true) @NotNull PersonajeDTO personajeDTO) throws Exception {
        return personajeServicio.nuevoPersonaje(personajeDTO);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Modificar un personaje--------------------------------------------------------
    @PatchMapping("/personajes/{id}")
    public ResponseEntity<Object> modificarPersonaje (@PathVariable long id,
                                                      @RequestBody(required = true) @NotNull PersonajeDTO personajeDTO) throws Exception {
        return personajeServicio.modificarPersonaje(id, personajeDTO);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Eliminar un personaje---------------------------------------------------------
    @DeleteMapping("/personajes/{id}")
    public ResponseEntity<Object> eliminarPersonaje (@PathVariable long id){
        return personajeServicio.eliminarPersonaje(id);
    }
//----------------------------------------------------------------------------------------------------------------------
}
