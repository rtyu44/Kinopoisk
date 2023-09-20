package com.example.kino.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto{

    private Integer kinopoiskId;
    private String nameRu;
    private String nameOriginal;
    private Integer ratingImdb;
    private Integer year;
    private String description;

}
