package com.videoclub.dao;

import com.videoclub.dao.base.MovieDao;
import com.videoclub.dao.model.Movie;

import java.util.*;
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
    public boolean update(Movie movieToUpdate) {
        return this.movies
                .stream()
                .filter(m -> Objects.equals(m.getId(), movieToUpdate.getId()))
                .map(m -> m = movieToUpdate)
                .findFirst()
                .isPresent();
    }

    @Override
    public void delete(Long id) {
        this.movies = this.movies
                .stream()
                .filter(movie -> movie.getId() != id)
                .collect(Collectors.toList());
    }
}
