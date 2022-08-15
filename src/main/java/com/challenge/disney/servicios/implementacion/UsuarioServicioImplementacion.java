package com.challenge.disney.servicios.implementacion;

import com.challenge.disney.dtos.UsuarioDTO;
import com.challenge.disney.modelos.Usuario;
import com.challenge.disney.repositorios.UsuarioRepositorio;
import com.challenge.disney.servicios.EmailSenderServicio;
import com.challenge.disney.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImplementacion implements UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailSenderServicio emailSenderServicio;
    @Override
    public UsuarioDTO getUsuario(Authentication authentication) {
        Usuario usuario = usuarioRepositorio.findByEmail(authentication.getName());
        return new UsuarioDTO(usuario);
    }

    @Override
    public List<UsuarioDTO> getUsuarios() {
        return usuarioRepositorio.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Object> crearUsuario(UsuarioDTO usuarioDTO) {
        if(usuarioDTO.getEmail().isBlank() && usuarioDTO.getNombre().isBlank() && usuarioDTO.getApellido().isBlank() && usuarioDTO.getContraseña().isBlank()){
            return ResponseEntity.badRequest().body("Datos inválidos");
        }
        if(usuarioRepositorio.findByEmail(usuarioDTO.getEmail()) != null){
            return ResponseEntity.badRequest().body("Usuario ya registrado");
        }
        Usuario usuario = new Usuario(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getEmail(), passwordEncoder.encode(usuarioDTO.getContraseña()));
        usuarioRepositorio.save(usuario);
        emailSenderServicio.sendEmail(usuario.getEmail(), "Bienvenido",
                "<p>Bienvenido usuario: </p>" + usuario.getNombre() +
                "<p>Use el siguiente enlace para confirmar su registro: </p>" + "<a>enlace</a>");

        return ResponseEntity.accepted().body("Usuario creado satisfactoriamente");
    }
}
