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
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;

//@NoArgsConstructor
@RequiredArgsConstructor
@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    private final FilmDaoImpl filmDaoImpl;
    private final FilmDao filmDao;
    private final FilmClient filmClient;
    private final XStream xStream;
    private final Email email;

    @Autowired
    private JavaMailSender emailSender;

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
        for(Film film1: film){

        }

    }

}
