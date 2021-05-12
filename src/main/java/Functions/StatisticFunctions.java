package Functions;

import dao.StatisticDao;

public class StatisticFunctions {

    static StatisticDao statisticDao = new StatisticDao();

    public static void showTotalNumbersOfActorsAndDirectors() {

        statisticDao.showTotalNumbersOfActorsAndDirectors();

    }

    public static void showNumberOfActorsInAMovie(Long movieId) {

        statisticDao.showNumberOfActorsInAMovie(movieId);

    }

    public static void showActorsFemaleToMaleDistribution() {

        statisticDao.showActorsFemaleToMaleDistribution();
    }

    public static void showMovieWithLowestAverageRating() {

        statisticDao.showMovieWithLowestAverageRating();
    }
}
