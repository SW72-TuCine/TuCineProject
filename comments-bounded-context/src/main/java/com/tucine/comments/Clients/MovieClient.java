package com.tucine.comments.Clients;


import com.tucine.comments.shared.response.MovieResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cineclub-administration-service",path = "/api/TuCine/v1/cineclub_administration")
public interface MovieClient {
/*    @RequestMapping("/films/verify/{filmId}")
    boolean checkIfMovieExists( @PathVariable("filmId") Long  filmId) throws RuntimeException;*/

    @GetMapping("/films/getById/{id}")
    public ResponseEntity<MovieResponse> getFilmById(@PathVariable("id") Long id);
}
