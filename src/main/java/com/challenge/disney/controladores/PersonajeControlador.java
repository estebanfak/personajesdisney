package com.challenge.disney.controladores;

import com.challenge.disney.dtos.PersonajeDTO;
import com.challenge.disney.servicios.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonajeControlador {
    @Autowired
    private PersonajeServicio personajeServicio;

    @GetMapping("/personajes")
    public List<PersonajeDTO> getAll(){
        return personajeServicio.getAll();
    }
}
