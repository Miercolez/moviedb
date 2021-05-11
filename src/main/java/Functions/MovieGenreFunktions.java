package Functions;

import dao.MovieGenreDao;
import models.MovieGenre;

public class MovieGenreFunktions {

    static MovieGenreDao movieGenreDao = new MovieGenreDao();

    public static void CreateNewGenre(String genre) {
        MovieGenre movieGenre = new MovieGenre(genre);
        movieGenreDao.NewMovieGenre(movieGenre);
    }
}
