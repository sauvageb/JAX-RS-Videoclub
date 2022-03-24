package com.videoclub.dao;

import com.videoclub.dao.base.MovieDao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static MovieDao getMovieDao(){
        return new MemoryMovieDao();
    }
}
