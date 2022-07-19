package com.challenge.disney.servicios.implementacion;

import com.challenge.disney.dtos.PersonajeDTO;
import com.challenge.disney.repositorios.PersonajeRepositorio;
import com.challenge.disney.servicios.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PersonajeServicioImplementacion implements PersonajeServicio {
    @Autowired
    private PersonajeRepositorio personajeRepositorio;

    @Override
    public List<PersonajeDTO> getAll() {
        return personajeRepositorio.findAll().stream().map(personaje -> new PersonajeDTO(personaje)).collect(Collectors.toList());
    }
}
