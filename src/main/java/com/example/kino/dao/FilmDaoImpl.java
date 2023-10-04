package com.example.kino.dao;

import com.example.kino.dto.FilmFilterDto;
import com.example.kino.model.Film;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FilmDaoImpl{

    private FilmDao filmDao;
    private final EntityManager em;


    public List<Film> sort(FilmFilterDto f) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cr = cb.createQuery(Film.class);
        Root<Film> root = cr.from(Film.class);
        List<Predicate> pr = new ArrayList<>();
        if (f.getKeyword() != null) {
            List<String> str = new ArrayList<>();
            str.add(f.getKeyword());
            for (String s : str) {
                pr.add(cb.like(root.get("nameRu"), "%" + s + "%"));
            }
        }
        if (f.getGenre() != null) {
            pr.add(cb.like(root.get("genres"), "%" + f.getGenre() + "%"));
        }
        if (f.getRatingFrom() != null) {
            pr.add(cb.gt(root.get("ratingImdb"), f.getRatingFrom()));
        }
        if (f.getRatingTo() != null) {
            pr.add(cb.lt(root.get("ratingImdb"), f.getRatingTo()));
        }
        if (f.getYearFrom() != null) {
            pr.add(cb.gt(root.get("year"), f.getYearFrom()));
        }
        if (f.getYearTo() != null) {
            pr.add(cb.lt(root.get("year"), f.getYearTo()));
        }
        cr.select(root).where(pr.toArray(new Predicate[0]));
        TypedQuery<Film> query = em.createQuery(cr);
        return query.getResultList();

    }

    public Integer idFilm(Integer id) {
        try {
            return filmDao.findByKinopoiskId(id).getKinopoiskId();
        } catch (NoResultException | NullPointerException e) {
            return 0;
        }

    }
}
