package com.tucine.comments.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cineclub-administration-service",path = "/api/TuCine/v1/cineclub_administration")
public interface CinemaClient {
    @RequestMapping("/cineclubs/verify/{cinemaId}")
    boolean checkIfCinemaExists( @PathVariable("cinemaId") Long  cinemaId) throws RuntimeException;
}
