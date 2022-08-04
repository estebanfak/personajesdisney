package com.challenge.disney;

import com.challenge.disney.modelos.*;
import com.challenge.disney.repositorios.*;
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
	public CommandLineRunner initData(PersonajeRepositorio personajeRepositorio, PeliculaRepositorio peliculaRepositorio, GeneroRepositorio generoRepositorio, PersonajePeliculaRepositorio personajePeliculaRepositorio, GeneroPeliculaRepositorio generoPeliculaRepositorio){
		return (args) -> {

			Personaje personaje1 = new Personaje("www.algo.com", "Cenicienta", "Se durmió", 21, 50);
			Personaje personaje2 = new Personaje("www.algo1.com", "Ariel", "Es un pescado", 28, 55);
			Personaje personaje3 = new Personaje("www.algo2.com", "Mulan", "India", 25, 52);
			Personaje personaje4 = new Personaje("www.algo3.com", "Simba", "León", 3, 49);
			Personaje personaje5 = new Personaje("www.algo4.com", "Aladín", "León", 3, 49);

			personajeRepositorio.save(personaje1);
			personajeRepositorio.save(personaje2);
			personajeRepositorio.save(personaje3);
			personajeRepositorio.save(personaje4);
			personajeRepositorio.save(personaje5);

			Pelicula pelicula1 = new Pelicula("www.peli.com", "Cenicienta", LocalDate.of(1985,5,13), (byte) 5);
			Pelicula pelicula2 = new Pelicula("www.peli2.com", "La Sirenita", LocalDate.of(1983,6,13), (byte) 4);
			Pelicula pelicula3 = new Pelicula("www.peli3.com", "Mulan", LocalDate.of(1990,7,13), (byte) 3);
			Pelicula pelicula4 = new Pelicula("www.peli4.com", "El Rey León", LocalDate.of(1992,8,13), (byte) 4);
			Pelicula pelicula5 = new Pelicula("www.peli5.com", "Aladín", LocalDate.of(1996,9,13), (byte) 2);
			peliculaRepositorio.save(pelicula1);
			peliculaRepositorio.save(pelicula2);
			peliculaRepositorio.save(pelicula3);
			peliculaRepositorio.save(pelicula4);
			peliculaRepositorio.save(pelicula5);

			Genero genero1 = new Genero("Fantasia", "que se yo");
			Genero genero2 = new Genero("Acción", "que se yo");
			Genero genero3 = new Genero("Magia", "que se yo");
			Genero genero4 = new Genero("Porno", "que se yo");
			Genero genero5 = new Genero("Terror", "que se yo");
			generoRepositorio.save(genero1);
			generoRepositorio.save(genero2);
			generoRepositorio.save(genero3);
			generoRepositorio.save(genero4);
			generoRepositorio.save(genero5);

			PersonajePelicula personajePelicula1 = new PersonajePelicula(pelicula1, personaje1);
			PersonajePelicula personajePelicula2 = new PersonajePelicula(pelicula2, personaje2);
			PersonajePelicula personajePelicula3 = new PersonajePelicula(pelicula3, personaje3);
			PersonajePelicula personajePelicula4 = new PersonajePelicula(pelicula4, personaje4);
			PersonajePelicula personajePelicula5 = new PersonajePelicula(pelicula5, personaje1);
			personajePeliculaRepositorio.save(personajePelicula1);
			personajePeliculaRepositorio.save(personajePelicula2);
			personajePeliculaRepositorio.save(personajePelicula3);
			personajePeliculaRepositorio.save(personajePelicula4);
			personajePeliculaRepositorio.save(personajePelicula5);

			GeneroPelicula generoPelicula1 = new GeneroPelicula(genero1, pelicula1);
			GeneroPelicula generoPelicula2 = new GeneroPelicula(genero2, pelicula2);
			GeneroPelicula generoPelicula3 = new GeneroPelicula(genero3, pelicula3);
			GeneroPelicula generoPelicula4 = new GeneroPelicula(genero4, pelicula4);
			GeneroPelicula generoPelicula5 = new GeneroPelicula(genero5, pelicula1);

			generoPeliculaRepositorio.save(generoPelicula1);
			generoPeliculaRepositorio.save(generoPelicula2);
			generoPeliculaRepositorio.save(generoPelicula3);
			generoPeliculaRepositorio.save(generoPelicula4);
			generoPeliculaRepositorio.save(generoPelicula5);





		};
	}

}
