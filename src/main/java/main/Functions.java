package main;

import dao.MovieDao;
import models.Movie;

public class Functions {

    static MovieDao movieDao = new MovieDao();

    public static void createNewMovie(String movieTitle, Long movieDuration, int releaseYear) {
        Movie movie = new Movie(movieTitle, movieDuration, releaseYear);

        movieDao.createNewMovie(movie);
    }

    public static void showAllMovies() {

        movieDao.showAllMovies();

    }
}
