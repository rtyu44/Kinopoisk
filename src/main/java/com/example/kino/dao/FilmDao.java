package com.example.kino.dao;

import com.example.kino.dto.FilmFilterDto;
import com.example.kino.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmDao extends JpaRepository<Film, Long>{
    Film findByKinopoiskId(Integer kinopoiskId);
}
