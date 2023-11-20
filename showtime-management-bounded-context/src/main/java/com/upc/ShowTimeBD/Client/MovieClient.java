package com.upc.ShowTimeBD.Client;

import com.upc.ShowTimeBD.Shared.FilmResponse;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cineclub-administration-service",path = "/api/TuCine/v1/cineclub_administration")
public interface MovieClient {
    @RequestMapping("/films/verify/{filmId}")
    boolean checkIfMovieExist( @PathVariable("filmId") Long  filmId) throws RuntimeException;

    @GetMapping("/films/getById/{id}")
    public ResponseEntity<FilmResponse> getMovieById(@PathVariable("id") Long id);

}