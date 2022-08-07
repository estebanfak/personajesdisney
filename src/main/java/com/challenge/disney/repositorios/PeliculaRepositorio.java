package com.challenge.disney.repositorios;

import com.challenge.disney.modelos.Genero;
import com.challenge.disney.modelos.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long> {
    Pelicula findByTitulo(String nombre);
    List<Pelicula> findByGeneroPeliculas(Genero genero);
}
