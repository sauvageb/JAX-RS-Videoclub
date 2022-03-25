package com.videoclub.service;

import com.videoclub.controller.model.MovieReponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.MovieDao;

import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    public List<MovieReponse> fetchAll() {
        MovieDao movieDao = DaoFactory.getMovieDao();

        return movieDao
                .findAll()
                .stream()
                .map(m -> m.toDto())
                .collect(Collectors.toList());
    }
}
