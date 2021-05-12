package Menus;

import Functions.MovieGenreFunktions;
import utility.Genres;

import static utility.Read.*;

public class MovieGenreMenu {
    public static void genreMenu() {

        boolean loop = true;

        while (loop) {
            System.out.println("\n--|| Genre menu ||--");
            System.out.println("[1] - Load genres to database");
            System.out.println("[2] - Show all genres");
            System.out.println("[0] - Return to main");

            System.out.print("\nMake a choice: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    LoadGenreToDB();
                    break;
                case 2:
                    ShowAllGenre();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private static void ShowAllGenre() {
        MovieGenreFunktions.ShowAllGenre();
    }

    private static void LoadGenreToDB() {
        Genres[] genres = Genres.values();
        for (Genres genre : genres) {
            MovieGenreFunktions.AddGenre(genre);
        }

    }
}
