package com.challenge.disney.modelos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String imagen, titulo;
    private LocalDate fechaCreacion;
    private byte calificacion;

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
}
