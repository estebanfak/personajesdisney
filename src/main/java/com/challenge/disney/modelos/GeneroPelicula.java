package com.challenge.disney.modelos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class GeneroPelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genero_id")
    private Genero genero;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    public GeneroPelicula() {}

    public GeneroPelicula(Genero genero, Pelicula pelicula) {
        this.genero = genero;
        this.pelicula = pelicula;
    }

    public Long getId() {
        return id;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Pelicula getPelicula() {
        return pelicula;
    }
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
