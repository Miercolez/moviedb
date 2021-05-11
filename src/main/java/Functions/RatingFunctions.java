package Functions;

import dao.RatingDao;
import models.MovieRating;

public class RatingFunctions {

    static RatingDao ratingDao = new RatingDao();

    public static void addRating(Long movieId, int movieRating) {

        MovieRating rating = new MovieRating(movieRating);

        ratingDao.addRating(rating, movieId);
    }
}
