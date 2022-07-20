package com.challenge.disney.controladores;

import com.challenge.disney.dtos.GeneroDTO;
import com.challenge.disney.servicios.GeneroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
