package com.example.kino.controller;


import com.example.kino.client.FilmClient;
import com.example.kino.dto.FilmFilterDto;
import com.example.kino.dto.FilmRequestDto;
import com.example.kino.dto.FilmResponseDto;
import com.example.kino.model.Film;
import com.example.kino.service.FilmService;
import com.example.kino.service.FilmServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;



    @GetMapping("/")
    public FilmResponseDto addFilm(@ModelAttribute FilmRequestDto filmRequestDto) {
        FilmResponseDto film = filmService.addFilm(filmRequestDto);
        return film;
    }

    @GetMapping("/films")
    public List<Film> getFilms(@ModelAttribute FilmFilterDto filterDto){
        List<Film> films = filmService.sort(filterDto);
        return films;
    }
}
