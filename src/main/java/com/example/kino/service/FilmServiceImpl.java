package com.example.kino.service;

import com.example.kino.dao.FilmDao;
import com.example.kino.dto.FilmDTO;
import com.example.kino.model.Film;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoArgsConstructor
@Service
@Transactional
public class FilmServiceImpl implements FilmService {

    private FilmDao filmDao;

    public List<Film> filmList(FilmDTO f){
        return filmDao.findAll(f);
    }


}
