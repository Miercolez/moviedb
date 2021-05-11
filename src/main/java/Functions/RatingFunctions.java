package Functions;

import dao.RatingDao;
import models.MovieRating;

public class RatingFunctions {

    static RatingDao ratingDao = new RatingDao();

    public static void addRating(Long movieId, int movieRating) {

        MovieRating rating = new MovieRating(movieRating);

        ratingDao.addRating(rating, movieId);
    }

    public static void deleteRating(Long ratingId) {

        ratingDao.deleteRating(ratingId);
    }

    public static void showAllRatings() {

        ratingDao.showAllRatings();

    }

    public static void changeRating(Long ratingId, int newRating) {

        ratingDao.changeRating(ratingId, newRating);
    }
}
