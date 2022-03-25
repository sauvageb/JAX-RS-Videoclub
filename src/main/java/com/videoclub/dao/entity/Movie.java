package com.videoclub.dao.entity;

import com.videoclub.controller.model.MovieReponse;

import java.io.Serializable;
import java.time.LocalDate;

public class Movie implements Serializable {

    private Long id;
    private String title;
    private double duration;
    private LocalDate releaseDate;

    public Movie() {
    }

    public Movie(String title, double duration, LocalDate releaseDate) {
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public MovieReponse toDto(){
        MovieReponse m = new MovieReponse();
        m.setId(this.id);
        m.setTitle(this.title);
        m.setDuration(this.duration);
        m.setReleaseDate(this.releaseDate);
        return m;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
