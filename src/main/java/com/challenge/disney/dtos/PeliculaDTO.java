package com.challenge.disney.dtos;

import com.challenge.disney.modelos.Pelicula;

import java.time.LocalDate;
import java.util.Date;

public class PeliculaDTO {
    private Long id;
    private String imagen, titulo;
    private LocalDate fechaCreacion;
    private byte calificacion;

    public PeliculaDTO() {}

    public PeliculaDTO(Pelicula pelicula) {
        this.id = pelicula.getId();
        this.imagen = pelicula.getImagen();
        this.titulo = pelicula.getTitulo();
        this.fechaCreacion = pelicula.getFechaCreacion();
        this.calificacion = pelicula.getCalificacion();
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
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public byte getCalificacion() {
        return calificacion;
    }
}
