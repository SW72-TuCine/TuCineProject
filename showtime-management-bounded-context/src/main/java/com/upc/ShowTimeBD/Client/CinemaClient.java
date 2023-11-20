package com.upc.ShowTimeBD.Client;

import com.upc.ShowTimeBD.Shared.CinemaResponse;
import com.upc.ShowTimeBD.Shared.FilmResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//,url= "http://localhost:8082/"
@FeignClient(name = "cineclub-administration-service", path = "/api/TuCine/v1/cineclub_administration")
public interface CinemaClient {

    @RequestMapping("/cineclubs/verify/{cineclubId}")
    boolean checkIfCinemaExist(@PathVariable("cineclubId") Long cineclubId) throws RuntimeException;

    @GetMapping("/cineclubs/getById/{cineclubId}")
    public ResponseEntity<CinemaResponse> getCineclubById(@PathVariable("cineclubId") Long cineclubId);


}