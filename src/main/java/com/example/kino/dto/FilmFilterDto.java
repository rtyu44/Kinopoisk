package com.example.kino.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmFilterDto {
    Integer ratingFrom;
    Integer ratingTo;
    Integer yearFrom;
    Integer yearTo;
    String keyword;
    String genre;
    int pageNumber;
    int pageSize;
    String to;

}
