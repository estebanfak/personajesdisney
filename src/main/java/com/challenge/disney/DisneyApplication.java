package com.challenge.disney;

import com.challenge.disney.modelos.Pelicula;
import com.challenge.disney.modelos.Personaje;
import com.challenge.disney.repositorios.PeliculaRepositorio;
import com.challenge.disney.repositorios.PersonajeRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;


@SpringBootApplication
public class DisneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PersonajeRepositorio personajeRepositorio, PeliculaRepositorio peliculaRepositorio){
		return (args) -> {

			Personaje personaje1 = new Personaje("www.algo.com", "Cenicienta", "Se durmió", 21, 50);
			Personaje personaje2 = new Personaje("www.algo1.com", "Ariel", "Es un pescado", 28, 55);
			Personaje personaje3 = new Personaje("www.algo2.com", "Mulan", "India", 25, 52);
			Personaje personaje4 = new Personaje("www.algo3.com", "Simba", "León", 3, 49);
			personajeRepositorio.save(personaje1);
			personajeRepositorio.save(personaje2);
			personajeRepositorio.save(personaje3);
			personajeRepositorio.save(personaje4);

			Pelicula pelicula1 = new Pelicula("www.peli.com", "Cenicienta", LocalDate.of(1985,5,13), (byte) 5);
			peliculaRepositorio.save(pelicula1);

		};
	}

}
