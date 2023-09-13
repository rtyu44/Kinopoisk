package com.example.kino.dao;

import com.example.kino.model.Film;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FilmDaoImpl {

    private FilmDao filmDao;

    public Integer idFilm(Integer id) {
        try {
            return filmDao.findByKinopoiskId(id).getKinopoiskId();
        } catch (NoResultException e) {
            return 0;
        } catch (NullPointerException e1) {
            return 0;
        }

    }

}
