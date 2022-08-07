package com.challenge.disney.servicios.implementacion;

import com.challenge.disney.dtos.GeneroDTO;
import com.challenge.disney.modelos.Genero;
import com.challenge.disney.repositorios.GeneroRepositorio;
import com.challenge.disney.servicios.GeneroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroServicioImplementacion implements GeneroServicio {
    @Autowired
    private GeneroRepositorio generoRepositorio;
    @Override
    public List<GeneroDTO> getAll() {
        return generoRepositorio.findAll().stream().map(genero -> new GeneroDTO(genero)).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Object> crearGenero(GeneroDTO generoDTO) {
        if(generoDTO.getImagen().isBlank() || generoDTO.getNombre().isBlank()){
            return ResponseEntity.badRequest().body("Faltan datos");
        }
        Genero genero = new Genero(generoDTO.getNombre(), generoDTO.getImagen());
        generoRepositorio.save(genero);
        return ResponseEntity.accepted().body("Nuevo genero creado");
    }
}
