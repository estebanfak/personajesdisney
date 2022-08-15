package com.challenge.disney.servicios.implementacion;

import com.challenge.disney.dtos.PeliculaDTO;
import com.challenge.disney.modelos.Genero;
import com.challenge.disney.modelos.Pelicula;
import com.challenge.disney.modelos.Personaje;
import com.challenge.disney.modelos.PersonajePelicula;
import com.challenge.disney.repositorios.*;
import com.challenge.disney.servicios.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.challenge.disney.utiles.utiles.modificarPalabras;

@Service
public class PeliculaServicioImplementacion implements PeliculaServicio {
    @Autowired
    private PeliculaRepositorio peliculaRepositorio;
    @Autowired
    private PersonajeRepositorio personajeRepositorio;
    @Autowired
    private PersonajePeliculaRepositorio personajePeliculaRepositorio;
    @Autowired
    private GeneroPeliculaRepositorio generoPeliculaRepositorio;
    @Autowired
    private GeneroRepositorio generoRepositorio;
    @Override
    public List<PeliculaDTO> gelAll() {
        return peliculaRepositorio.findAll().stream().map(PeliculaDTO::new).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Object> nuevaPelicula(PeliculaDTO peliculaDTO) {
        if( peliculaDTO.getImagen().isBlank() ||
            peliculaDTO.getTitulo().isBlank() ||
            peliculaDTO.getFechaCreacion() == null ||
            peliculaDTO.getCalificacion()<0){
            return ResponseEntity.badRequest().body("Faltan datos");
        }
        Pelicula pelicula = new Pelicula(peliculaDTO.getImagen(), peliculaDTO.getTitulo(), peliculaDTO.getFechaCreacion(), peliculaDTO.getCalificacion());
        peliculaRepositorio.save(pelicula);

        if(peliculaDTO.getPersonajes().size()>0){
            peliculaDTO.getPersonajes().forEach(element -> {
                System.out.println(element);
                if(personajeRepositorio.findByNombre((element)) != null){
                    PersonajePelicula personajePelicula = new PersonajePelicula();
                    personajePelicula.setPelicula(pelicula);
                    personajePelicula.setPersonaje(personajeRepositorio.findByNombre(element));
                    personajePeliculaRepositorio.save(personajePelicula);
                }
            });
        }
        return ResponseEntity.accepted().body("Pelicula creada");
    }

    @Override
    public ResponseEntity<Object> modificarPelicula(long id, PeliculaDTO peliculaDTO) {

        Pelicula pelicula = peliculaRepositorio.findById(id).orElse(null);
        if(pelicula == null){
            return ResponseEntity.badRequest().body("Pelicula no encontrada");
        }
        if(!peliculaDTO.getImagen().isBlank()){
            pelicula.setImagen(peliculaDTO.getImagen());
        }
        if(!peliculaDTO.getTitulo().isBlank()){
            pelicula.setTitulo(peliculaDTO.getTitulo());
        }
        if(peliculaDTO.getFechaCreacion() != null){
            pelicula.setFechaCreacion(peliculaDTO.getFechaCreacion());
        }
        if(String.valueOf(peliculaDTO.getCalificacion()).isBlank()){
            pelicula.setCalificacion(peliculaDTO.getCalificacion());
        }
        peliculaRepositorio.save(pelicula);
        return ResponseEntity.accepted().body("Pelicula modificada");
    }

    @Override
    public ResponseEntity<Object> eliminarPelicula(long id) {
        Pelicula pelicula = peliculaRepositorio.findById(id).orElse(null);
        if(pelicula == null){
            return ResponseEntity.badRequest().body("Pelicula Inexistente");
        }

        if(pelicula.getPersonajePeliculas().size()>0){
            pelicula.getPersonajePeliculas().forEach(element ->{
                personajePeliculaRepositorio.deleteById(element.getId());
            });
        }
        if(pelicula.getGeneroPeliculas().size()>0){
            pelicula.getGeneroPeliculas().forEach(element ->{
                generoPeliculaRepositorio.deleteById(element.getId());
            });
        }
        peliculaRepositorio.deleteById(id);
        return ResponseEntity.accepted().body("Pelicula eliminado");
    }

    @Override
    public List<PeliculaDTO> buscarPelicula(String campo, String param) {
        if(param.isBlank() || param.isEmpty() || param.equals(" ") || campo.isBlank() || campo.isEmpty() || campo.equals(" ")){
            return peliculaRepositorio.findAll().stream().map(PeliculaDTO::new).collect(Collectors.toList());
        }
        if(campo.toLowerCase().equals("name")){
            String paramName = modificarPalabras(param);
            return peliculaRepositorio.findAll().stream().filter(element -> modificarPalabras(element.getTitulo()).contains(paramName)).map(PeliculaDTO::new).collect(Collectors.toList());
        }
        if(campo.toLowerCase().equals("gender")){
            long paramId = Long.parseLong(param);
            Genero genero = generoRepositorio.findById(paramId).orElse(null);
            assert genero != null;
            List<PeliculaDTO> listaPelisPorGenero = new ArrayList<>();
            genero.getGeneroPeliculas().forEach(generos -> listaPelisPorGenero.add(new PeliculaDTO(peliculaRepositorio.findByTitulo(generos.getPelicula().getTitulo()))));
            return listaPelisPorGenero;
        }
        if(campo.toLowerCase().equals("order")){
            List<PeliculaDTO> listaOrdenada = peliculaRepositorio.findAll().stream().map(PeliculaDTO::new).sorted(Comparator.comparing(PeliculaDTO::getTitulo)).collect(Collectors.toList());
            if(param.toLowerCase().equals("asc")){
                return listaOrdenada;
            }
            if(param.toLowerCase().equals("desc")){
                Collections.reverse(listaOrdenada);
                return listaOrdenada;
            }
            return peliculaRepositorio.findAll().stream().map(PeliculaDTO::new).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public ResponseEntity<Object> agregarPersonajeAPelicula(long idMovie, long idCharacter) {
        Pelicula pelicula = peliculaRepositorio.findById(idMovie).orElse(null);
        Personaje personaje = personajeRepositorio.findById(idCharacter).orElse(null);
        assert pelicula != null;
        if(pelicula.getPersonaje().contains(personaje)){
            return ResponseEntity.badRequest().body("El personaje " + personaje.getNombre() + ", ya se encuentra dentro del reparto de la pelicula " + "'" + pelicula.getTitulo() + "'");
        }
        PersonajePelicula personajePelicula = new PersonajePelicula(pelicula, personaje);
        personajePeliculaRepositorio.save(personajePelicula);
        return ResponseEntity.accepted().body("El personaje " + personaje.getNombre() + " fue agregado al reparto de la pelicula " + "'" + pelicula.getTitulo() + "'");
    }

    @Override
    public ResponseEntity<Object> eliminarPersonajeAPelicula(long idMovie, long idCharacter) {
        Pelicula pelicula = peliculaRepositorio.findById(idMovie).orElse(null);
        Personaje personaje = personajeRepositorio.findById(idCharacter).orElse(null);

        assert pelicula != null;
        if(!pelicula.getPersonaje().contains(personaje)){
            return ResponseEntity.badRequest().body("El personaje " + personaje.getNombre() + " no participó de la pelicula " + pelicula.getTitulo());
        }

        pelicula.getPersonajePeliculas().forEach(element ->{
            if (element.getPersonaje().equals(personaje)){

                System.out.println("Poronga");
                personajePeliculaRepositorio.deleteById(element.getId());
            }
        });
        return ResponseEntity.accepted().body("El personaje " + personaje.getNombre() + " fue eliminado del reparto de la pelicula " + "'" + pelicula.getTitulo() + "'");
    }
}