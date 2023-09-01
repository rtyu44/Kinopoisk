package com.example.kino.dao;

import com.example.kino.dto.FilmDTO;
import com.example.kino.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmDao extends JpaRepository<Film, Long> {
    List<Film> findAll(FilmDTO f);
}
