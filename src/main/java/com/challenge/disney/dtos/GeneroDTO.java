package com.challenge.disney.dtos;

import com.challenge.disney.modelos.Genero;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneroDTO {
    private long id;
    private String nombre, imagen;
    private Set<String> peliculas = new HashSet<>();

    public GeneroDTO() {
    }

    public GeneroDTO(Genero genero) {
        this.id = genero.getId();
        this.nombre = genero.getNombre();
        this.imagen = genero.getImagen();
        this.peliculas = genero.getGeneroPeliculas().stream().map(element -> new GeneroPeliculaDTO(element).getPelicula()).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getImagen() {
        return imagen;
    }
    public Set<String> getPeliculas() {
        return peliculas;
    }
}
