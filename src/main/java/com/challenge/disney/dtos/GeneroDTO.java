package com.challenge.disney.dtos;

import com.challenge.disney.modelos.Genero;

public class GeneroDTO {
    private long id;
    private String nombre, imagen;

    public GeneroDTO() {
    }

    public GeneroDTO(Genero genero) {
        this.id = genero.getId();
        this.nombre = genero.getNombre();
        this.imagen = genero.getImagen();
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
}
