package com.challenge.disney.dtos;

import com.challenge.disney.modelos.GeneroPelicula;

public class GeneroPeliculaDTO {
    private long id;
    private String pelicula, genero;

    public GeneroPeliculaDTO() {
    }

    public GeneroPeliculaDTO(GeneroPelicula generoPelicula) {
        this.id = generoPelicula.getId();
        this.pelicula = generoPelicula.getPelicula().getTitulo();
        this.genero = generoPelicula.getGenero().getNombre();
    }

    public long getId() {
        return id;
    }
    public String getPelicula() {
        return pelicula;
    }
    public String getGenero() {
        return genero;
    }
}
