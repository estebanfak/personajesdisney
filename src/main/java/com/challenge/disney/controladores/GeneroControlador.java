package com.challenge.disney.controladores;

import com.challenge.disney.dtos.GeneroDTO;
import com.challenge.disney.modelos.Genero;
import com.challenge.disney.servicios.GeneroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GeneroControlador {
    @Autowired
    private GeneroServicio generoServicio;

    @GetMapping("/genero")
    public List<GeneroDTO> getAll(){
        return generoServicio.getAll();
    }
//----------------------------------------Modificar un personaje--------------------------------------------------------
    @PostMapping("/genero")
    public ResponseEntity<Object> crearGenero(@RequestBody GeneroDTO generoDTO){
        return generoServicio.crearGenero(generoDTO);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Modificar un personaje--------------------------------------------------------
}
