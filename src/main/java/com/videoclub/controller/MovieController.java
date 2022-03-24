package com.videoclub.controller;

import com.videoclub.model.Movie;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class MovieController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1L, "La ligne verte", 188, LocalDate.ofYearDay(1999, 1)));
        movies.add(new Movie(2L, "Le parrain", 175, LocalDate.ofYearDay(1972, 1)));
        movies.add(new Movie(3L, "H2G2 ", 109, LocalDate.ofYearDay(2005, 1)));
        movies.add(new Movie(4L, "Que justice soit faite", 104, LocalDate.ofYearDay(2009, 1)));
        movies.add(new Movie(5L, "Les affranchis", 146, LocalDate.ofYearDay(1990, 1)));
        movies.add(new Movie(6L, "Metropolis", 153, LocalDate.ofYearDay(1927, 1)));
        movies.add(new Movie(7L, "Blade Runner 2049", 163, LocalDate.ofYearDay(2017, 1)));
        movies.add(new Movie(8L, "Princesse Mononoké", 133, LocalDate.ofYearDay(1997, 1)));
        movies.add(new Movie(9L, "Transformers", 224, LocalDate.ofYearDay(2007, 1)));

        return Response.ok(movies).build();
    }

}
