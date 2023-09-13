package com.example.kino.controller;


import com.example.kino.client.FilmClient;
import com.example.kino.dto.FilmDto;
import com.example.kino.dto.FilmFilterDto;
import com.example.kino.dto.FilmRequestDto;
import com.example.kino.dto.FilmResponseDto;
import com.example.kino.mapper.UbiMapper;
import com.example.kino.model.Film;
import com.example.kino.service.FilmService;
import com.example.kino.service.FilmServiceImpl;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/v2/films")
public class FilmController {

    private final FilmService filmService;
    private final FilmClient filmClient;
    private final UbiMapper mapper;
//    private final FilmFilterDto filmFilterDto;
    private RestTemplate restTemplate;



    @GetMapping("/")
    public FilmResponseDto addFilm(@ModelAttribute FilmRequestDto filmRequestDto) {
        FilmResponseDto film = filmService.addFilm(filmRequestDto);
        return film;
    }


//    @GetMapping("/")
//    public List<FilmDto> getAllFilms(FilmRequestDto filmRequestDto) {
//        return filmService.findAll(filmRequestDto).stream()
//                .map(mapper::FilmRepDto)
//                .collect(Collectors.toList());
//    }


//
//    @PostMapping("/")
//    public List<FilmDto> addFilms(FilmRequestDto filmRequestDto) {
//        return filmService.saveFilms(filmRequestDto).stream()
//                .map(mapper::FilmRepDto)
//                .collect(Collectors.toList());
//    }
//    @GetMapping("/")
//    public List<FilmDto> getFilms(@RequestParam("limit") int limit,
//                                  @RequestParam("genre") String genre) {
//        // Параметры запроса API Кинопоиска
//        String url = "https://kinopoiskapiunofficial.tech/api/v2.2/films";
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("limit", String.valueOf(limit));
//        params.add("genre", genre);
//
//        // Получение данных с API Кинопоиска
//        ResponseEntity<List<FilmDto>> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                new HttpEntity<>(params),
//                new ParameterizedTypeReference<List<FilmDto>>() {},
//                params);
//
//        // Полученный список фильмов
//        List<FilmDto> films = response.getBody();
//
//        // Сохранение фильмов в базу данных
//        filmService.saveFilms(films);
//
//        return films;
//    }
}
