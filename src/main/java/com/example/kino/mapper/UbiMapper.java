package com.example.kino.mapper;

import com.example.kino.dto.FilmDto;
import com.example.kino.dto.FilmResponseDto;
import com.example.kino.model.Film;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UbiMapper {

    @Autowired
    private ModelMapper map;

    public FilmDto FilmRepDto(Film f){
        FilmDto filmDto = map.map(f,FilmDto.class);
        return filmDto;
    }

    public Film FilmRep(FilmDto f){
        Film film =  map.map(f, Film.class);
        return film;
    }
}
