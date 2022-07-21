package com.challenge.disney.modelos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String imagen, titulo;
    private LocalDate fechaCreacion;
    private byte calificacion;
    @OneToMany(mappedBy="pelicula", fetch=FetchType.EAGER)
    private Set<PersonajePelicula> personajePeliculas = new HashSet<>();

    @OneToMany(mappedBy="pelicula", fetch=FetchType.EAGER)
    private Set<GeneroPelicula> generoPeliculas = new HashSet<>();

    public Pelicula() {
    }

    public Pelicula(String imagen, String titulo, LocalDate fechaCreacion, byte calificacion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
    }

    public Long getId() {
        return id;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public byte getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(byte calificacion) {
        this.calificacion = calificacion;
    }
    public Set<PersonajePelicula> getPersonajePeliculas() {
        return personajePeliculas;
    }
    public void setPersonajePeliculas(Set<PersonajePelicula> personajePeliculas) {
        this.personajePeliculas = personajePeliculas;
    }
    public void addPersonajePelicula(PersonajePelicula personajePelicula) {
        personajePelicula.setPelicula(this);
        personajePeliculas.add(personajePelicula);
    }
    public Set<Personaje> getPersonaje(){
        return personajePeliculas.stream().map(personaje -> personaje.getPersonaje()).collect(Collectors.toSet());
    }
    public Set<GeneroPelicula> getGeneroPeliculas() {
        return generoPeliculas;
    }
    public void setGeneroPeliculas(Set<GeneroPelicula> generoPeliculas) {
        this.generoPeliculas = generoPeliculas;
    }
    public void addGeneroPelicula(GeneroPelicula generoPelicula) {
        generoPelicula.setPelicula(this);
        getGeneroPeliculas().add(generoPelicula);
    }
}
