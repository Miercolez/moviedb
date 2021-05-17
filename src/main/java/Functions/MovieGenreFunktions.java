package Functions;

import dao.MovieGenreDao;
import models.MovieGenre;
import utility.Genres;

public class MovieGenreFunktions {

    private static final MovieGenreDao movieGenreDao = new MovieGenreDao();

    public static void closeEmf() {
        movieGenreDao.closeEmf();
    }

    public static void AddGenre(Genres genre) {
        MovieGenre movieGenre = new MovieGenre(genre);
        movieGenreDao.AddGenre(movieGenre);
    }

    public static void ShowAllGenre() {
        movieGenreDao.ShowAllGenre();
    }

}
