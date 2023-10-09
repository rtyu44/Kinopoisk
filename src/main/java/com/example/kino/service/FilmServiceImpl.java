package com.example.kino.service;

import com.example.kino.client.FilmClient;
import com.example.kino.config.Email;
import com.example.kino.dao.FilmDao;
import com.example.kino.dao.FilmDaoImpl;
import com.example.kino.dto.FilmFilterDto;
import com.example.kino.dto.FilmRequestDto;
import com.example.kino.dto.FilmResponseDto;
import com.example.kino.model.Film;
import com.thoughtworks.xstream.XStream;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    private final FilmDaoImpl filmDaoImpl;
    private final FilmDao filmDao;
    private final FilmClient filmClient;
    private final XStream xStream;
    private final Email email;

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

    @Override
    public void getEmail(FilmFilterDto f) throws IOException, MessagingException {

        List<Film> film = filmDaoImpl.sort(f);
        File file = new File("C:\\XML/file.xml");
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedWriter file1 = new BufferedWriter(new FileWriter(file));
        for(Film f2: film) {
            String dataXML = xStream.toXML(f2);
            file1.write(dataXML);
        }
        file1.close();

        email.getEmail(f.getTo());

    }

}
