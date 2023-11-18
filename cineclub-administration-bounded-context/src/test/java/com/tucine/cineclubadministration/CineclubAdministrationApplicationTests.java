package com.tucine.cineclubadministration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tucine.cineclubadministration.Cineclub.service.impl.CineclubServiceImpl;
import com.tucine.cineclubadministration.Film.dto.receive.ActorReceiveDto;
import com.tucine.cineclubadministration.Film.dto.receive.FilmReceiveDto;
import com.tucine.cineclubadministration.Film.helpers.TheMovieDatabaseHelper;
import com.tucine.cineclubadministration.Film.service.impl.FilmServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@SpringBootTest
class CineclubAdministrationApplicationTests {

	/*@Test
	void Test1StringDatabase() {
		System.out.println(TheMovieDatabaseHelper.getMovieTrailerSrcVideo("507089"));
	}

	@Test
	void Test2ConvertDataYear(){
		System.out.println(TheMovieDatabaseHelper.DateTimeFormatterGetYears("2021-03-31"));
	}

	@Test
	void Test3GetDurationFilmById(){
		System.out.println(TheMovieDatabaseHelper.getDurationExternalMovie("507089"));
	}

	@Test
	void Test4GetRatingFilmById(){
		System.out.println(TheMovieDatabaseHelper.getContentRatingNameFromExternalMovie("507089"));
	}

	@Test
	void Test5GetPrincipalActorsFilmByIdMovieExternalAPI(){

		List<Integer> lista = TheMovieDatabaseHelper.getFirstFiveActorIdsFromExternalMovie("507089");
		lista.forEach(System.out::println);
	}

	@Test
	void Test6GetPrincipalActorsFilmByIdMovieExternalAPI(){

		List<ActorReceiveDto> listaActores = TheMovieDatabaseHelper.getActorsFromExternalMovie("507089");
		listaActores.forEach(System.out::println);
	}

	@Test
	void Test7GetFilmInformationFromExternalAPI(){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		// Tu objeto que deseas imprimir
		FilmReceiveDto film = TheMovieDatabaseHelper.getInformationAboutMovieFromExternalAPI("331061");
		try {
			// Convertir el objeto a formato JSON y luego imprimirlo
			String jsonString = objectMapper.writeValueAsString(film);
			System.out.println(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void Test8(){


	}
*/
}
