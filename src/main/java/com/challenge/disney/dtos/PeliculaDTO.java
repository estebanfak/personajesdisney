package com.challenge.disney.dtos;

import com.challenge.disney.modelos.Pelicula;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PeliculaDTO {
    private Long id;
    private String imagen, titulo;
    private int fechaCreacion;
    private byte calificacion;
    private Set<String> personajes = new HashSet<>();
    private Set<String> generos = new HashSet<>();

    public PeliculaDTO() {}

    public PeliculaDTO(Pelicula pelicula) {
        this.id = pelicula.getId();
        this.imagen = pelicula.getImagen();
        this.titulo = pelicula.getTitulo();
        this.fechaCreacion = pelicula.getFechaCreacion();
        this.calificacion = pelicula.getCalificacion();
        this.personajes = pelicula.getPersonajePeliculas().stream().map(personajePelicula -> new PersonajePeliculaDTO(personajePelicula).getPersonaje()).collect(Collectors.toSet());
        this.generos = pelicula.getGeneroPeliculas().stream().map(element -> new GeneroPeliculaDTO(element).getGenero()).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }
    public String getImagen() {
        return imagen;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getFechaCreacion() {
        return fechaCreacion;
    }
    public byte getCalificacion() {
        return calificacion;
    }
    public Set<String> getPersonajes() {
        return personajes;
    }
    public Set<String> getGeneros() {
        return generos;
    }
}