package com.example.kino.client;

import com.example.kino.dto.FilmDTO;
import com.example.kino.dto.FilmRequestDTO;
import com.example.kino.dto.FilmResponseDTO;
import com.example.kino.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FilmClient {

    private RestTemplate restTemplate;
    private static final String urlFilms = "https://kinopoiskapiunofficial.tech/api/v2.2/films";

    public FilmResponseDTO restFilm(FilmRequestDTO requestDTO){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("X-API-KEY", "f7021df5-fc38-4d31-8db5-742902d14f63");
        HttpEntity<FilmResponseDTO> req = new HttpEntity<>(httpHeaders);
        ResponseEntity<FilmResponseDTO> response = restTemplate.exchange(urlFilms(requestDTO),
                HttpMethod.GET, req, FilmResponseDTO.class);
        FilmResponseDTO film = response.getBody();
        return film;

    }


    private String urlFilms(FilmRequestDTO filmRequestDto){
        return ;
    }


}
