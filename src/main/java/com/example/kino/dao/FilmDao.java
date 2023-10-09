package com.example.kino.dao;

import com.example.kino.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmDao extends JpaRepository<Film, Long>{
    Film findByKinopoiskId(Integer kinopoiskId);
}
