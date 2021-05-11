package main;

import java.util.Scanner;


import static Menus.MovieMenu.movieMenu;
import static Menus.RatingMenu.ratingMenu;

public class Main {
    static boolean loopMainMenu = true;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        while (loopMainMenu) {
            mainMenu();
        }
    }

    public static void mainMenu() {

        System.out.println("\n--|| Main menu ||--");
        System.out.println("[1] - Movie");
        System.out.println("[2] - Actor");
        System.out.println("[3] - Director");
        System.out.println("[4] - Rating");
        System.out.println("[5] - Genre");
        System.out.println("[0] - Exit");

        System.out.print("\nMake a choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:

                movieMenu();

                break;
            case 2:

                actorMenu();

                break;
            case 3:

                directorMenu();

                break;
            case 4:

                ratingMenu();

                break;
            case 5:

                genreMenu();

                break;
            case 0:
                loopMainMenu = false;
                break;
            default:
                System.out.println("Wrong input!");
        }
    }

}
