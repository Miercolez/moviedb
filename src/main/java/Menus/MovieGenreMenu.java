package Menus;

import Functions.MovieGenreFunktions;

import static utility.Read.*;

public class MovieGenreMenu {
    public static void genreMenu() {

        boolean loop = true;

        while (loop) {
            System.out.println("\n--|| Genre menu ||--");
            System.out.println("[1] - Add genre");
            System.out.println("[2] - Change genre");
            System.out.println("[3] - Delete genre");
            System.out.println("[4] - Show all genres");
            System.out.println("[0] - Return to main");

            System.out.print("\nMake a choice: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    AddGenre();
                    break;
                case 2:
                    ChangeGenre();
                    break;
                case 3:
                    DeleteGenre();
                    break;
                case 4:
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

    private static void DeleteGenre() {
        MovieGenreFunktions.ShowAllGenre();
        System.out.print("\n Genre id: ");
        Long id = readLong();
        MovieGenreFunktions.DeleteGenre(id);
    }

    private static void ChangeGenre() {
        MovieGenreFunktions.ShowAllGenre();
        System.out.print("\nGenre id: ");
        Long id = readLong();
        System.out.print("New genre name: ");
        String newName = readLine();
        MovieGenreFunktions.ChangeGenre(id, newName);
    }

    private static void ShowAllGenre() {
        MovieGenreFunktions.ShowAllGenre();
    }

    private static void AddGenre() {
        System.out.print("Genre: ");
        String genre = readLine();
        MovieGenreFunktions.AddGenre(genre);
    }
}
