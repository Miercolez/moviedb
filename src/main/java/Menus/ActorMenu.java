package Menus;

import Functions.ActorFunctions;

import static main.Main.sc;
import static main.Read.*;

public class ActorMenu {
    public static void actorMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--|| Actor menu ||--");
            System.out.println("[1] - Add actor");
            System.out.println("[2] - Change name");
//        System.out.println("[3] - Change age");
//        System.out.println("[4] - Change gender");
//        System.out.println("[5] - Delete actor");
        System.out.println("[6] - Show all actors");
            System.out.println("[0] - Return to main");

            System.out.print("\nMake a choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addNewActor();
                    break;
                case 2:
                    showAllActors();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    showAllActors();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private static void showAllActors() {
        ActorFunctions.showAllActors();
    }

    private static void addNewActor() {
        System.out.println("Name: ");
        String actorName = readLine();
        System.out.println("Age: ");
        int actorAge = readInt();
        String actorGender;
        System.out.println("Gender: ");
        System.out.println("1. Man");
        System.out.println("2. Woman");
        int choice = readInt();
        if (choice == 1) {
            actorGender = "Man";
            ActorFunctions.addNewActor(actorName, actorAge, actorGender);
        } else if (choice == 2) {
            actorGender = "Woman";
            ActorFunctions.addNewActor(actorName, actorAge, actorGender);
        } else {
            System.out.println("Wrong input, that gender does not exist");
        }


    }
}
