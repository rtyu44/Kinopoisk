package com.example.kino.controller;


import com.example.kino.dto.FilmFilterDto;
import com.example.kino.dto.FilmRequestDto;
import com.example.kino.dto.FilmResponseDto;
import com.example.kino.model.Film;
import com.example.kino.service.FilmService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public List<Film> getFilms(@ModelAttribute FilmFilterDto f){
        List<Film> films = filmService.sort(f);
        return films;
    }

    @GetMapping("/email")
    public String getEmail(@ModelAttribute FilmFilterDto f) throws IOException, MessagingException {
        filmService.getEmail(f);
        return "OK";
    }
}
