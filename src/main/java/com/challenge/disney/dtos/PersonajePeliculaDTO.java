package com.challenge.disney.dtos;

import com.challenge.disney.modelos.PersonajePelicula;


public class PersonajePeliculaDTO {
    private long id;
    private String pelicula, personaje;

    public PersonajePeliculaDTO() {
    }

    public PersonajePeliculaDTO(PersonajePelicula personajePelicula) {
        this.id = personajePelicula.getId();
        this.pelicula = personajePelicula.getPelicula().getTitulo();
        this.personaje = personajePelicula.getPersonaje().getNombre();
    }

    public long getId() {
        return id;
    }
    public String getPelicula() {
        return pelicula;
    }
    public String getPersonaje() {
        return personaje;
    }
}
