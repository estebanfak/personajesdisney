package com.challenge.disney.repositorios;

import com.challenge.disney.modelos.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonajeRepositorio extends JpaRepository<Personaje, Long> {
    Personaje findByNombre(String nombre);
}
