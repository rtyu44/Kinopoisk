package com.example.kino.service;

import com.example.kino.dto.FilmDto;
import com.example.kino.dto.FilmFilterDto;
import com.example.kino.dto.FilmRequestDto;
import com.example.kino.dto.FilmResponseDto;
import com.example.kino.model.Film;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface FilmService {
    FilmResponseDto addFilm(FilmRequestDto filmRequestDto);
}
