package com.challenge.disney.controladores;

import com.challenge.disney.dtos.UsuarioDTO;
import com.challenge.disney.servicios.EmailSenderServicio;
import com.challenge.disney.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioControlador {
    @Autowired
    private EmailSenderServicio emailSenderServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
//----------------------------------------Usuario autenticado-----------------------------------------------------------
    @GetMapping("/usuario/actual")
    public UsuarioDTO getUsuario(Authentication authentication) {
        return usuarioServicio.getUsuario(authentication);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Todos los usuarios------------------------------------------------------------
    @GetMapping("/usuarios")
    public List<UsuarioDTO> getUsuarios() {
        return usuarioServicio.getUsuarios();
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Crear nuevo usuario-----------------------------------------------------------
    @PostMapping("/usuarios")
    public ResponseEntity<Object> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioServicio.crearUsuario(usuarioDTO);
    }
//----------------------------------------------------------------------------------------------------------------------
}
