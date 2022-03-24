package com.videoclub.dao;

import com.videoclub.dao.base.MovieDao;
import com.videoclub.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryMovieDao implements MovieDao {

    private static Long idSequence = 0L;
    private static List<Movie> movies = new ArrayList<>();

    @Override
    public Long save(Movie movie) {
        movie.setId(++idSequence);
        movies.add(movie);
        return movie.getId();
    }

    @Override
    public List<Movie> findAll() {
        return Collections.unmodifiableList(movies);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return this.movies.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst();
    }

    @Override
    public Movie update(Movie movieToUpdate) {
        //TODO
        return null;
    }

    @Override
    public void delete(Long id) {
        this.movies = this.movies
                .stream()
                .filter(movie -> movie.getId() != id)
                .collect(Collectors.toList());
    }
}
