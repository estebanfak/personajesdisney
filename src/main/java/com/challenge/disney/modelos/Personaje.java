package com.challenge.disney.modelos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String imagen, nombre, historia;
    private int edad;
    private double peso;
    @OneToMany(mappedBy="personaje", fetch=FetchType.EAGER)
    private Set<PersonajePelicula> personajePeliculas = new HashSet<>();

    public Personaje() {
    }

    public Personaje(String nombre, String imagen, String historia, int edad, double peso) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.historia = historia;
        this.edad = edad;
        this.peso = peso;
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
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getHistoria() {
        return historia;
    }
    public void setHistoria(String historia) {
        this.historia = historia;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public Set<PersonajePelicula> getPersonajePeliculas() {
        return personajePeliculas;
    }
    public void setPersonajePeliculas(Set<PersonajePelicula> personajePeliculas) {
        this.personajePeliculas = personajePeliculas;
    }
    public void addPersonajePelicula(PersonajePelicula personajePelicula) {
        personajePelicula.setPersonaje(this);
        personajePeliculas.add(personajePelicula);
    }
    public Set<Pelicula> getPeliculas(){
        return personajePeliculas.stream().map(pelicula -> pelicula.getPelicula()).collect(Collectors.toSet());
    }
}
