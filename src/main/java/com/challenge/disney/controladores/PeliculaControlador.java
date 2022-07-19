package com.challenge.disney.controladores;

import com.challenge.disney.dtos.PeliculaDTO;
import com.challenge.disney.servicios.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeliculaControlador {
    @Autowired
    private PeliculaServicio peliculaServicio;

    @GetMapping("/peliculas")
    public List<PeliculaDTO> gelAll(){
        return peliculaServicio.gelAll();
    }
}
