package com.videoclub.controller;

import com.videoclub.controller.model.CreateMovie;
import com.videoclub.controller.model.MovieReponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.MovieDao;
import com.videoclub.dao.entity.Movie;
import com.videoclub.service.MovieService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/movies")
public class MovieController {

    @Inject
    MovieService movieService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<MovieReponse> movieReponses = movieService.fetchAll();
        return Response.ok(movieReponses).build();
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
