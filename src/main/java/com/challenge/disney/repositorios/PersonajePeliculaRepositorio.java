package com.challenge.disney.repositorios;

import com.challenge.disney.modelos.Personaje;
import com.challenge.disney.modelos.PersonajePelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonajePeliculaRepositorio extends JpaRepository<PersonajePelicula, Long> {

}
