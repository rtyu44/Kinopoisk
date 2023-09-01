package com.example.kino.dto;

import com.example.kino.model.Film;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmResponseDTO {
    Long total;
    Long totalPages;
    List<Film> items;
}
