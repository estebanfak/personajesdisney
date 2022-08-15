package com.challenge.disney.dtos;

import com.challenge.disney.modelos.Usuario;

public class UsuarioDTO {
    private Long id;
    private String nombre, apellido, email, contraseña;

    public UsuarioDTO() {}

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.email = usuario.getEmail();
        this.contraseña = usuario.getContraseña();
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
    public String getContraseña() {
        return contraseña;
    }
}
