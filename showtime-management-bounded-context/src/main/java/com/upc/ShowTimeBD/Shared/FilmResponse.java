package com.upc.ShowTimeBD.Shared;

import lombok.Data;

@Data
public class FilmResponse {
    Long id;
    String tittle;
    String year;
    String synopsis;
    int duration;
}
