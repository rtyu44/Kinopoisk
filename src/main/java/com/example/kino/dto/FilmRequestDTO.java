package com.example.kino.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmRequestDTO {
    String keyword;
    Integer genre;
    Integer ratingFrom;
    Integer yearFrom;
    Integer page;
}
