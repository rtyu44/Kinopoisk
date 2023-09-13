package com.example.kino.dto;

import com.example.kino.model.Film;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmResponseDto {
    Long total;
    Long totalPages;
    List<Film> items;

}
