package com.challenge.disney.dtos;

import com.challenge.disney.modelos.Usuario;

public class UsuarioDTO {
    private Long id;
    private String nombre, apellido, email, contrasena;

    public UsuarioDTO() {}

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.email = usuario.getEmail();
        this.contrasena = usuario.getContrasena();
    }

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getEmail() {
        return email;
    }
    public String getContrasena() {
        return contrasena;
    }
}
