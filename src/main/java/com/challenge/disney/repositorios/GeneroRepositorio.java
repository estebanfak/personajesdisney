package com.challenge.disney.repositorios;

import com.challenge.disney.modelos.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GeneroRepositorio extends JpaRepository<Genero, Long> {
    Genero findByNombre(String nombre);
}
