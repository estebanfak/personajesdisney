package com.challenge.disney.dtos;

import com.challenge.disney.modelos.Personaje;
import com.challenge.disney.modelos.PersonajePelicula;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonajeDTO {

    private Long id;
    private String imagen, nombre, historia;
    private int edad;
    private double peso;
    private Set<String> peliculas = new HashSet<>();

    public PersonajeDTO() {
    }

    public PersonajeDTO(Personaje personaje) {
        this.id = personaje.getId();
        this.imagen = personaje.getImagen();
        this.nombre = personaje.getNombre();
        this.historia = personaje.getHistoria();
        this.edad = personaje.getEdad();
        this.peso = personaje.getPeso();
        this.peliculas = personaje.getPersonajePeliculas().stream().map(personajePelicula -> new PersonajePeliculaDTO(personajePelicula).getPelicula()).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }
    public String getImagen() {
        return imagen;
    }
    public String getNombre() {
        return nombre;
    }
    public String getHistoria() {
        return historia;
    }
    public int getEdad() {
        return edad;
    }
    public double getPeso() {
        return peso;
    }
    public Set<String> getPeliculas() {
        return peliculas;
    }
}
