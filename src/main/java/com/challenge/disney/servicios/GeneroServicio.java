package com.challenge.disney.servicios;

import com.challenge.disney.dtos.GeneroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GeneroServicio {
    List<GeneroDTO> getAll();
    ResponseEntity<Object> crearGenero(GeneroDTO generoDTO);
}
