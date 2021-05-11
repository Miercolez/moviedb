package Menus;

import Functions.DirectorFunctions;

import static main.Main.sc;
import static main.Read.*;
import static utility.Genderchoice.chooseGender;

public class DirectorMenu {

    private static void directorMenu() {

        boolean loop = true;

        while (loop) {
            System.out.println("\n--|| Director menu ||--");
            System.out.println("[1] - Add director");
//        System.out.println("[2] - Change name");
//        System.out.println("[3] - Change age");
//        System.out.println("[4] - Change gender");
//        System.out.println("[5] - Delete director");
//        System.out.println("[6] - Show all directors");
//        System.out.println("[0] - Return to main");

            System.out.print("\nMake a choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addDirector();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private static void addDirector() {
        System.out.println("Director name: ");
        String directorName = readLine();

        System.out.println("Age: ");
        int directorAge = readInt();

        String directorGender = chooseGender();

        DirectorFunctions.addDirector(directorName,directorAge,directorGender);
    }

}