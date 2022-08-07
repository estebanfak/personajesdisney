package com.challenge.disney.controladores;

import com.challenge.disney.dtos.PersonajeDTO;
import com.challenge.disney.servicios.PersonajeServicio;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/personajes")
    public ResponseEntity<Object> nuevoPersonaje(@RequestBody(required = true) @NotNull PersonajeDTO personajeDTO){
        return personajeServicio.nuevoPersonaje(personajeDTO);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Modificar un personaje--------------------------------------------------------
    @PatchMapping("/personajes/{id}")
    public ResponseEntity<Object> modificarPersonaje (@PathVariable long id,
                                                      @RequestBody(required = true) @NotNull PersonajeDTO personajeDTO){
        return personajeServicio.modificarPersonaje(id, personajeDTO);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Eliminar un personaje---------------------------------------------------------
    @DeleteMapping("/personajes/{id}")
    public ResponseEntity<Object> eliminarPersonaje (@PathVariable long id){
        return personajeServicio.eliminarPersonaje(id);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Buscar un personaje-----------------------------------------------------------
    @GetMapping("/characters/{campo}/{param}")
    public List<PersonajeDTO> buscarPersonaje (@PathVariable(value = "campo") String campo,
                                               @PathVariable(value = "param") String param){
        return personajeServicio.buscarPersonaje(campo, param);
    }
}