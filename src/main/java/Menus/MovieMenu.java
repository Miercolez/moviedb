package Menus;

import Functions.MovieFunctions;

import static Menus.ActorMenu.showAllActors;
import static main.Main.*;
import static main.Read.*;

public class MovieMenu {

    public static void movieMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--|| Movie menu ||--");
            System.out.println("[1] - Add new movie");
        System.out.println("[2] - Add existing actor to existing movie");
//        System.out.println("[3] - Add existing director");
//        System.out.println("[4] - Add genre");
            System.out.println("[5] - Change movie title");
//        System.out.println("[6] - Change actor");
//        System.out.println("[7] - Change director");
            System.out.println("[8] - Delete movie");
//        System.out.println("[9] - Remove actor from movie");
//        System.out.println("[10] - Remove director from movie");
//        System.out.println("[11] - Remove genre from movie");
            System.out.println("[12] - Show all movies");
            System.out.println("[0] - Return to main");

            System.out.print("\nMake a choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addNewMovie();
                    break;
                case 2:
                    addExistingActorToExistingMovie();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    showAllMovies();

                    changeMovieTitle();
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    showAllMovies();

                    deleteMovie();
                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:
                    showAllMovies();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private static void addExistingActorToExistingMovie() {
        showAllActors();
        System.out.println("Actor id: ");
        Long actorId = readLong();
        showAllMovies();
        System.out.println("Movie id: ");
        Long movieId = readLong();
        MovieFunctions.addExistingActorToExistingMovie(actorId, movieId);

    }

    private static void showAllMovies() {
        MovieFunctions.showAllMovies();
        System.out.println();
    }

    private static void deleteMovie() {
        System.out.println("Movie id: ");
        Long movieId = readLong();
        MovieFunctions.deleteMovie(movieId);
    }

    private static void changeMovieTitle() {
        System.out.println("Movie id: ");
        Long movieId = readLong();

        System.out.println("New title: ");
        String newMovieTitle = readLine();

        MovieFunctions.changeMovieTitle(movieId, newMovieTitle);
    }

    private static void addNewMovie() {
        System.out.println("Movie title: ");
        String movieTitle = readLine();
        System.out.println("Duration: ");
        Long movieDuration = readLong();
        System.out.println("Release year: ");
        int releaseYear = readInt();

        MovieFunctions.createNewMovie(movieTitle, movieDuration, releaseYear);
    }

}
