package com.example.kino.service;

import com.example.kino.client.FilmClient;
import com.example.kino.dao.FilmDao;
import com.example.kino.dao.FilmDaoImpl;
import com.example.kino.dto.FilmFilterDto;
import com.example.kino.dto.FilmRequestDto;
import com.example.kino.dto.FilmResponseDto;
import com.example.kino.model.Film;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@NoArgsConstructor
@RequiredArgsConstructor
@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    private final FilmDaoImpl filmDaoImpl;
    private final FilmDao filmDao;
    private final FilmClient filmClient;

    @Override
    public FilmResponseDto addFilm(FilmRequestDto filmRequestDto){
        FilmResponseDto frd = filmClient.restFilm(filmRequestDto);
        List<Film> films = frd.getItems();
        for(Film f: films){
            Integer a = f.getKinopoiskId();
            if(!a.equals(filmDaoImpl.idFilm(a))){
                filmDao.save(f);
            }
        }
        return frd;
    }

    @Override
    public List<Film> sort(FilmFilterDto filterDto) {
        return filmDaoImpl.sort(filterDto);
    }

}
