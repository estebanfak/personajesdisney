package com.challenge.disney.repositorios;

import com.challenge.disney.modelos.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long> {
}
