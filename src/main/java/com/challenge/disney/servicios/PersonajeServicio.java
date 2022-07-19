package com.challenge.disney.servicios;

import com.challenge.disney.dtos.PersonajeDTO;

import java.util.List;

public interface PersonajeServicio {
    List<PersonajeDTO> getAll();
}
