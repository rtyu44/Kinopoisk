package com.example.kino.service;

import com.example.kino.client.FilmClient;
import com.example.kino.dao.FilmDao;
import com.example.kino.dao.FilmDaoImpl;
import com.example.kino.dto.FilmDto;
import com.example.kino.dto.FilmFilterDto;
import com.example.kino.dto.FilmRequestDto;
import com.example.kino.dto.FilmResponseDto;
import com.example.kino.mapper.UbiMapper;
import com.example.kino.model.Film;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmDaoImpl filmDaoimpl;
    @Autowired
    private FilmDao filmDao;
    @Autowired
    private FilmClient filmClient;
    @Autowired
    private UbiMapper mapper;


    @Override
    public FilmResponseDto addFilm(FilmRequestDto filmRequestDto){
        FilmResponseDto frd = filmClient.restFilm(filmRequestDto);
        List<Film> films = frd.getItems();
        for(Film f: films){
            Integer a = f.getKinopoiskId();
            if(!a.equals(filmDaoimpl.idFilm(a))){
                filmDao.save(f);
            }
        }
        return frd;
    }

//    public void saveFilms(List<Film> films) {
//        for (Film film : films) {
//            if (filmDao.findByTitleAndDirector(film.getTitle(), film.getDirector()) == null) {
//                filmRepository.save(film);
//            }
//        }
//    }

//    @Override
//    public List<Film> filmList(FilmFilterDto filmFilterDto) {
//        return null;
//    }
//
//    @Override
//    public FilmResponseDto addFilm(FilmFilterDto filmFilterDto) {
//        return null;
//    }
//
//    public void saveFilms(List<FilmDto> filmDtos) {
//        List<Film> films = filmDtos.stream()
//                .map(dto -> mapper.FilmRep(dto, Film.class))
//                .collect(Collectors.toList());
//        filmDao.saveAll(films);
//    }

//    public void addFilmsFromExternalAPI(Map<String, String> parameters) {
//        String url = "https://kinopoiskapiunofficial.tech/api/v2.2/films";
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class, parameters);
//        List films = response.getBody();
//
//        for (Object filmObj : films) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            Film film = objectMapper.convertValue(filmObj, Film.class);
//
//            if (filmDao.findByKinopoiskId(film.getKinopoiskId()) == null) {
//                filmDao.save(film);
//            }
//        }
//    }

}
