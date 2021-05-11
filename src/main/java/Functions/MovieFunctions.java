package Functions;

import dao.MovieDao;
import models.Movie;

public class MovieFunctions {

    static MovieDao movieDao = new MovieDao();

    public static void createNewMovie(String movieTitle, Long movieDuration, int releaseYear) {
        Movie movie = new Movie(movieTitle, movieDuration, releaseYear);

        movieDao.createNewMovie(movie);
    }

    public static void showAllMovies() {

        movieDao.showAllMovies();

    }

    public static void deleteMovie(Long id) {
        movieDao.deleteMovie(id);
    }

    public static void changeMovieTitle(Long id, String title) {
        movieDao.changeMovieTitle(id,title);
    }

    public static void addExistingActorToExistingMovie(Long actorId, Long movieId) {
        movieDao.addExistingActorToExistingMovie(actorId, movieId);

    }

    public static void addExistingDirectorToExistingMovie(Long directorId, Long movieId) {

        movieDao.updateDirectorOfMovie(directorId, movieId);

    }

    public static void changeActor(Long movieId, Long oldActorId, Long newActorId) {
        movieDao.changeActor(movieId, oldActorId, newActorId);

    }

    public static void changeDirector(Long movieId, Long newDirectorId) {

        movieDao.updateDirectorOfMovie(newDirectorId, movieId);
    }

    public static void removeActorFromMovie(Long movieId, Long actorId) {
        movieDao.removeActorFromMovie(movieId, actorId);
    }
}
