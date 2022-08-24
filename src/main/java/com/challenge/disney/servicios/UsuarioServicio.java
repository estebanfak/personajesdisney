package com.challenge.disney.servicios;

import com.challenge.disney.dtos.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface UsuarioServicio {
    UsuarioDTO getUsuario(Authentication authentication);
    List<UsuarioDTO> getUsuarios();
    ResponseEntity<?> crearUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO getUsuariosPorId(long id);
}
