package com.challenge.disney.modelos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String nombre, imagen;
    @OneToMany(mappedBy = "genero", fetch = FetchType.EAGER)
    private Set<GeneroPelicula> generoPeliculas = new HashSet<>();

    public Genero() {
    }

    public Genero(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<GeneroPelicula> getGeneroPeliculas() {
        return generoPeliculas;
    }

    public void setGeneroPeliculas(Set<GeneroPelicula> generoPeliculas) {
        this.generoPeliculas = generoPeliculas;
    }

    public void addGeneroPelicula(GeneroPelicula generoPelicula) {
        generoPelicula.setGenero(this);
        getGeneroPeliculas().add(generoPelicula);
    }
}
