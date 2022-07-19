package com.challenge.disney.servicios.implementacion;

import com.challenge.disney.dtos.PeliculaDTO;
import com.challenge.disney.repositorios.PeliculaRepositorio;
import com.challenge.disney.servicios.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculaServicioImplementacion implements PeliculaServicio {
    @Autowired
    private PeliculaRepositorio peliculaRepositorio;
    @Override
    public List<PeliculaDTO> gelAll() {
        return peliculaRepositorio.findAll().stream().map(pelicula -> new PeliculaDTO(pelicula)).collect(Collectors.toList());
    }
}
