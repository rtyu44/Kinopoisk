package com.example.kino.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Films")
@Data
@NoArgsConstructor

public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kinopoiskId")
    private Integer kinopoiskId;

    @Column(name = "nameRu")
    private String nameRu;
    @Column(name = "ratingImdb")
    private Integer ratingImdb;
    @Column(name = "year")
    private Integer year;
    @Column(name = "description")
    private String description;
    @Column(name = "nameOriginal")
    private String nameOriginal;

    public Film(Integer kinopoiskId, String nameRu, Integer ratingImdb, Integer year, String description, String nameOriginal) {
        this.kinopoiskId = kinopoiskId;
        this.nameRu = nameRu;
        this.ratingImdb = ratingImdb;
        this.year = year;
        this.description = description;
        this.nameOriginal =nameOriginal;
    }


}