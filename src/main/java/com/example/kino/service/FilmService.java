package com.example.kino.service;

import com.example.kino.dto.FilmFilterDto;
import com.example.kino.dto.FilmRequestDto;
import com.example.kino.dto.FilmResponseDto;
import com.example.kino.model.Film;
import jakarta.mail.MessagingException;

import java.io.IOException;
import java.util.List;

public interface FilmService {
    FilmResponseDto addFilm(FilmRequestDto filmRequestDto);
    List<Film> sort(FilmFilterDto filterDto);

    void getEmail(FilmFilterDto f) throws IOException, MessagingException;

}
