package Menus;

import Functions.StatisticFunctions;
import models.MovieGenre;
import utility.Genres;

import static utility.Read.*;

public class StatisticMenu {


    public static void statisticMenu() {

        boolean loop = true;

        while (loop) {

            System.out.println("\n--|| Statistic menu ||--");
            System.out.println("[1] - Show Total Number of Actors and Directors");
            System.out.println("[2] - Show Number of Actors in A Movie");

            System.out.println("[3] - Show All Movies in a Specific Genre");

            System.out.println("[4] - Show Actor Female-Male Percentage Distribution for All movies");
            System.out.println("[5] - Show The Movie with the Lowest Average Rating");
            System.out.println("[6] - Show The Movie with the Highest Average Rating");
            System.out.println("[0] - Return to main");

            System.out.print("\nMake a choice: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    showTotalNumbersOfActorsAndDirectors();
                    break;
                case 2:
                    showNumberOfActorsInAMovie();
                    break;
                case 3:
                    showAllMoviesInASpecificGenre();
                    break;
                case 4:
                    showActorsFemaleToMaleDistribution();
                    break;
                case 5:
                    showMovieWithLowestAverageRating();
                    break;
                case 6:
                    showMovieWithHighestAverageRating();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private static void showMovieWithHighestAverageRating() {

        StatisticFunctions.showMovieWithHighestAverageRating();
    }

    private static void showMovieWithLowestAverageRating() {

        StatisticFunctions.showMovieWithLowestAverageRating();
    }

    private static void showActorsFemaleToMaleDistribution() {

        StatisticFunctions.showActorsFemaleToMaleDistribution();
    }

    private static void showAllMoviesInASpecificGenre() {
        Genres genre = readGenre();
        StatisticFunctions.showAllMoviesInASpecificGenre(genre);

    }

    private static void showNumberOfActorsInAMovie() {

//        MovieMenu.showAllMovies();
        System.out.println("Movie Id: ");
        Long movieId = readLong();

        StatisticFunctions.showNumberOfActorsInAMovie(movieId);
    }

    private static void showTotalNumbersOfActorsAndDirectors() {

        StatisticFunctions.showTotalNumbersOfActorsAndDirectors();

    }
}
