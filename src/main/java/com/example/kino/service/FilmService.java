package com.example.kino.service;

import com.example.kino.dto.FilmDTO;
import com.example.kino.model.Film;

import java.util.List;

public interface FilmService {
    List<Film> filmList(FilmDTO f);
}
