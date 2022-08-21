package com.challenge.disney.controladores;

import com.challenge.disney.dtos.PeliculaDTO;
import com.challenge.disney.servicios.PeliculaServicio;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeliculaControlador {
    @Autowired
    private PeliculaServicio peliculaServicio;
//----------------------------------------Todas las peliculas-----------------------------------------------------------
    @GetMapping("/peliculas")
    public List<PeliculaDTO> gelAll(){
        return peliculaServicio.gelAll();
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Crear nueva pelicula----------------------------------------------------------
    @PostMapping("/peliculas")
    public ResponseEntity<Object> nuevaPelicula(@RequestBody(required = true) @NotNull PeliculaDTO peliculaDTO){
        return peliculaServicio.nuevaPelicula(peliculaDTO);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Modificar una pelicula--------------------------------------------------------
    @PatchMapping("/peliculas/{id}")
    public ResponseEntity<Object> modificarPelicula (@PathVariable long id,
                                                      @RequestBody(required = true) @NotNull PeliculaDTO peliculaDTO){
        return peliculaServicio.modificarPelicula(id, peliculaDTO);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Eliminar una pelicula---------------------------------------------------------
    @DeleteMapping("/peliculas/{id}")
    public ResponseEntity<Object> eliminarPelicula (@PathVariable long id){
        return peliculaServicio.eliminarPelicula(id);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Buscar una pelicula-----------------------------------------------------------
    @GetMapping("/peliculas/{campo}/{param}")
    public List<PeliculaDTO> buscarPelicula (@PathVariable(value = "campo") String campo,
                                               @PathVariable(value = "param") String param){
        return peliculaServicio.buscarPelicula(campo, param);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Agregar personaje a una pelicula----------------------------------------------
    @PostMapping("/movies/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Object> agregarPersonajeAPelicula (@PathVariable(value = "idMovie") long idMovie,
                                                             @PathVariable(value = "idCharacter") long idCharacter){
        return peliculaServicio.agregarPersonajeAPelicula(idMovie, idCharacter);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------Eliminar personaje de una pelicula--------------------------------------------
    @DeleteMapping("movies/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Object> eliminarPersonajeAPelicula (@PathVariable long idMovie,
                                                             @PathVariable long idCharacter){
        return peliculaServicio.eliminarPersonajeAPelicula(idMovie, idCharacter);
    }
//----------------------------------------------------------------------------------------------------------------------
    // TODO -> Documentación

    // TODO -> Tests
}