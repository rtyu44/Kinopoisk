package com.example.kino.controller;


import com.example.kino.dto.FilmDTO;
import com.example.kino.model.Film;
import com.example.kino.service.FilmService;
import com.example.kino.service.FilmServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;
    private RestTemplate restTemplate;

    @GetMapping("/films")
    public List<Film> getFilm(@ModelAttribute FilmDTO f) {
        List<Film> films = filmService.filmList(f);
        return films;
    }

//    @GetMapping("/films/{id}")
//    public ResponseEntity getUnicornByIdByEntity(@PathVariable final String id) {
//        return restTemplate.getForEntity(
//                "https://kinopoiskapiunofficial.tech/api/v2.2/" + id,
//                String.class);
//    }
}
