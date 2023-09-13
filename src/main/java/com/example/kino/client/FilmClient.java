package com.example.kino.client;

import com.example.kino.dto.FilmDto;
import com.example.kino.dto.FilmRequestDto;
import com.example.kino.dto.FilmResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.NamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FilmClient {
    @Autowired
    private RestTemplate restTemplate;
    private static final String urlFilms = "https://kinopoiskapiunofficial.tech/api/v2.2/films";



    public FilmResponseDto restFilm(FilmRequestDto requestDto){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("X-API-KEY", "f7021df5-fc38-4d31-8db5-742902d14f63");
        HttpEntity<FilmResponseDto> req = new HttpEntity<>(httpHeaders);
        ResponseEntity<FilmResponseDto> response = restTemplate.exchange(urlFilms(requestDto),
                HttpMethod.GET, req, FilmResponseDto.class);
        FilmResponseDto film = response.getBody();
        return film;
    }

    private String urlFilms(FilmRequestDto requestDTO) {
        String builder = UriComponentsBuilder
                .fromUriString(urlFilms)
                .queryParam("keyword", requestDTO.getKeyword())
                .queryParam("genre", requestDTO.getGenre())
                .queryParam("yearFrom", requestDTO.getYearFrom())
                .queryParam("ratingFrom", requestDTO.getRatingFrom())
                .queryParam("page", requestDTO.getPage())
                .build().toUriString();
        return builder;

    }
}
