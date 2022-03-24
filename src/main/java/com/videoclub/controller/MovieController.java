package com.videoclub.controller;

import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.MovieDao;
import com.videoclub.model.CreateMovie;
import com.videoclub.model.Movie;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/movies")
public class MovieController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        MovieDao movieDao = DaoFactory.getMovieDao();
        List<Movie> movieList = movieDao.findAll();
        return Response.ok(movieList).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateMovie createMovie) {
        Movie movie = new Movie(createMovie.getTitle(), createMovie.getDuration(), createMovie.getReleaseDate());
        MovieDao movieDao = DaoFactory.getMovieDao();
        movieDao.save(movie);
        return Response.status(201).build();
    }

}
