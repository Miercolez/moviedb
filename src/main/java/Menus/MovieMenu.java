package Menus;

import Functions.MovieFunctions;
import dao.MovieDao;
import models.MovieGenre;
import utility.Genres;

import java.util.List;
import java.util.stream.Collectors;

import static Menus.ActorMenu.showAllActors;
import static Menus.DirectorMenu.showAllDirectors;
import static utility.Read.*;

public class MovieMenu {

    public static void movieMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--|| Movie menu ||--");
            System.out.println("[1] - Add new movie");
            System.out.println("[2] - Add existing actor to existing movie");
            System.out.println("[3] - Add existing director to existing movie");
            System.out.println("[4] - Add genre");
            System.out.println("[5] - Change movie title");
            System.out.println("[6] - Change actor");
            System.out.println("[7] - Change director");
            System.out.println("[8] - Delete movie");
            System.out.println("[9] - Remove actor from movie");
            System.out.println("[10] - Remove director from movie");
            System.out.println("[11] - Remove genre from movie");
            System.out.println("[12] - Show all movies");
            System.out.println("[0] - Return to main");

            System.out.print("\nMake a choice: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    addNewMovie();
                    break;
                case 2:
                    addExistingActorToExistingMovie();
                    break;
                case 3:
                    addExistingDirectorToExistingMovie();
                    break;
                case 4:
                    addGenreToMovie();
                    break;
                case 5:
                    changeMovieTitle();
                    break;
                case 6:
                    changeActor();
                    break;
                case 7:
                    changeDirector();
                    break;
                case 8:
                    deleteMovie();
                    break;
                case 9:
                    removeActorFromMovie();
                    break;
                case 10:
                    removeDirectorFromMovie();
                    break;
                case 11:
                    removeGenreFromMovie();
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

    private static void removeGenreFromMovie() {
        showAllMovies();
        System.out.println("Movie id: ");
        Long movieId = readLong();

        List<MovieGenre> genres = MovieFunctions.showGenreForMovie(movieId);

        if (genres.size() != 0) {
            List<String> genresString = genres.stream()
                    .map(g -> g.getGenre().getLabel())
                    .collect(Collectors.toList());
            int index = chooseFromGenreList(genresString) - 1;
            MovieGenre movieGenre = genres.get(index);
            MovieFunctions.removeGenreFromMovie(movieGenre, movieId);
        } else {
            System.out.println("No genres to remove");
        }
    }

    private static void addGenreToMovie() {
        showAllMovies();
        System.out.println("Movie id: ");
        Long movieId = readLong();
        Genres genre = readGenre();

        MovieFunctions.addGenreToMovie(movieId, genre);
    }

    private static void removeDirectorFromMovie() {
        showAllMovies();
        System.out.println("Movie id: ");
        Long movieId = readLong();

        MovieFunctions.removeDirectorFromMovie(movieId);
    }


    private static void removeActorFromMovie() {
        MovieDao movieDao = new MovieDao();
        showAllMovies();
        System.out.println("Movie id: ");
        Long movieId = readLong();

        System.out.println(movieDao.findMovie(movieId).getActors());

        System.out.println("Actor id: ");
        Long actorId = readLong();

        MovieFunctions.removeActorFromMovie(movieId, actorId);
    }

    private static void changeDirector() {
        showAllMovies();
        System.out.println("Movie id: ");
        Long movieId = readLong();
        showAllDirectors();
        System.out.println("New director id: ");
        Long newDirectorId = readLong();
        MovieFunctions.changeDirector(movieId, newDirectorId);
    }

    private static void changeActor() {
        MovieDao movieDao = new MovieDao();
        showAllMovies();
        System.out.println("Movie id: ");
        Long movieId = readLong();

        System.out.println(movieDao.findMovie(movieId).getActors());

        System.out.println("Actor id: ");
        Long oldActorId = readLong();

        showAllActors();
        System.out.println("New actor id: ");
        Long newActorId = readLong();

        MovieFunctions.changeActor(movieId, oldActorId, newActorId);

    }

    private static void addExistingDirectorToExistingMovie() {
        showAllDirectors();
        System.out.println("Director id: ");
        Long directorId = readLong();

        showAllMovies();
        System.out.println("Movie id: ");
        Long movieId = readLong();

        MovieFunctions.addExistingDirectorToExistingMovie(directorId, movieId);
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

    public static void showAllMovies() {
        MovieFunctions.showAllMovies();
        System.out.println();
    }

    private static void deleteMovie() {
        showAllMovies();
        System.out.println("Movie id: ");
        Long movieId = readLong();
        MovieFunctions.deleteMovie(movieId);
    }

    private static void changeMovieTitle() {
        showAllMovies();
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
