package com.challenge.disney.modelos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class PersonajePelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personaje_id")
    private Personaje personaje;

    public PersonajePelicula() {
    }

    public PersonajePelicula(Pelicula pelicula, Personaje personaje) {
        this.pelicula = pelicula;
        this.personaje = personaje;
    }

    public Long getId() {
        return id;
    }
    public Personaje getPersonaje() {
        return personaje;
    }
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
    public Pelicula getPelicula() {
        return pelicula;
    }
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }



}
