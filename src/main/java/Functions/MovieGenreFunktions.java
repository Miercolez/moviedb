package Functions;

import dao.MovieGenreDao;
import models.MovieGenre;

public class MovieGenreFunktions {

    private static final MovieGenreDao movieGenreDao = new MovieGenreDao();

    public static void AddGenre(String genre) {
        MovieGenre movieGenre = new MovieGenre(genre);
        movieGenreDao.AddGenre(movieGenre);
    }

    public static void ShowAllGenre() {
        movieGenreDao.ShowAllGenre();
    }

    public static void ChangeGenre(Long id, String newName) {
        movieGenreDao.ChangeGenre(id, newName);
    }


    public static void DeleteGenre(Long id) {
        movieGenreDao.DeleteGenre(id);
    }
}
