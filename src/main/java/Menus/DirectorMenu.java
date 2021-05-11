package Menus;

import Functions.DirectorFunctions;

import static utility.Read.*;
import static utility.GenderChoice.chooseGender;

public class DirectorMenu {

    public static void directorMenu() {

        boolean loop = true;

        while (loop) {
            System.out.println("\n--|| Director menu ||--");
            System.out.println("[1] - Add director");
            System.out.println("[2] - Change name");
            System.out.println("[3] - Change age");
            System.out.println("[4] - Change gender");
            System.out.println("[5] - Delete director");
            System.out.println("[6] - Show all directors");
            System.out.println("[0] - Return to main");

            System.out.print("\nMake a choice: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    addDirector();
                    break;
                case 2:
                    changeName();
                    break;
                case 3:
                    changeAge();
                    break;
                case 4:
                    changeGender();
                    break;
                case 5:
                    deleteDirector();
                    break;
                case 6:
                    showAllDirectors();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private static void deleteDirector() {
        showAllDirectors();

        System.out.println("Director id: ");
        Long directorId = readLong();

        DirectorFunctions.deleteDirector(directorId);

    }

    private static void changeGender() {
        showAllDirectors();

        System.out.println("Director id: ");
        Long directorId = readLong();

        String directorGender = chooseGender();

        DirectorFunctions.changeGender(directorId, directorGender);

    }

    public static void showAllDirectors() {
        DirectorFunctions.showAllDirectors();
    }

    private static void changeAge() {
        showAllDirectors();

        System.out.println("Director id: ");
        Long directorId = readLong();

        System.out.println("New age: ");
        int newDirectorAge = readInt();

        DirectorFunctions.changeAge(directorId, newDirectorAge);
    }

    private static void changeName() {
        showAllDirectors();

        System.out.println("Director id: ");
        Long directorId = readLong();

        System.out.println("New name: ");
        String newDirectorName = readLine();

        DirectorFunctions.changeName(directorId, newDirectorName);
    }

    private static void addDirector() {
        System.out.println("Director name: ");
        String directorName = readLine();

        System.out.println("Age: ");
        int directorAge = readInt();

        String directorGender = chooseGender();

        DirectorFunctions.addDirector(directorName, directorAge, directorGender);
    }

}