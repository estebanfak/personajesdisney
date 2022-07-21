package com.challenge.disney.repositorios;

import com.challenge.disney.modelos.GeneroPelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GeneroPeliculaRepositorio extends JpaRepository<GeneroPelicula, Long> {
}
