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

    @Column(name = "filmID")
    private Long filmID;

    @Column(name = "filmName")
    private String filmName;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "filmYear")
    private Integer filmYear;
    @Column(name = "description")
    private String description;

    public Film(String filmName, Integer rating, Integer filmYear) {
        this.id = id;
        this.filmID = filmID;
        this.filmName = filmName;
        this.rating = rating;
        this.filmYear = filmYear;
        this.description = description;
    }

    public Long getFilmID() {
        return filmID;
    }

    public void setFilmID(Long filmID) {
        this.filmID = filmID;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(Integer filmYear) {
        this.filmYear = filmYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}