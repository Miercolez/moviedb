package Menus;

import Functions.ActorFunctions;
import utility.GenderChoice;

import static utility.Read.*;

public class ActorMenu {
    public static void actorMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--|| Actor menu ||--");
            System.out.println("[1] - Add actor");
            System.out.println("[2] - Change name");
            System.out.println("[3] - Change age");
            System.out.println("[4] - Change gender");
            System.out.println("[5] - Delete actor");
            System.out.println("[6] - Show all actors");
            System.out.println("[0] - Return to main");

            System.out.print("\nMake a choice: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    addNewActor();
                    break;
                case 2:
                    changeActorName();
                    break;
                case 3:
                    changeActorAge();
                    break;
                case 4:
                    changeActorGender();
                    break;
                case 5:
                    deleteActor();
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

    private static void deleteActor() {
        showAllActors();
        System.out.println("Actor id: ");
        Long actorId = readLong();
        ActorFunctions.deleteActor(actorId);
    }

    private static void changeActorGender() {
        showAllActors();
        System.out.println("Actor id: ");
        Long actorId = readLong();
        String actorGender = GenderChoice.chooseGender();
        ActorFunctions.changeActorGender(actorId, actorGender);
    }

    private static void changeActorAge() {
        showAllActors();
        System.out.println("Actor id: ");
        Long actorId = readLong();
        System.out.println("New actor age: ");
        int newActorAge = readInt();
        ActorFunctions.changeActorAge(actorId, newActorAge);
    }

    private static void changeActorName() {
        showAllActors();
        System.out.println("Actor id: ");
        Long actorId = readLong();
        System.out.println("New actor name: ");
        String newActorName = readLine();
        ActorFunctions.changeActorName(actorId, newActorName);
    }

    public static void showAllActors() {
        ActorFunctions.showAllActors();
    }

    private static void addNewActor() {
        System.out.println("Name: ");
        String actorName = readLine();
        System.out.println("Age: ");
        int actorAge = readInt();
        String actorGender = GenderChoice.chooseGender();
//        System.out.println("Gender: ");
//        System.out.println("1. Man");
//        System.out.println("2. Woman");
//        int choice = readInt();
//        if (choice == 1) {
//            actorGender = "Man";
//            ActorFunctions.addNewActor(actorName, actorAge, actorGender);
//        } else if (choice == 2) {
//            actorGender = "Woman";
//
//        } else {
//            System.out.println("Wrong input, that gender does not exist");
//        }

        ActorFunctions.addNewActor(actorName, actorAge, actorGender);

    }
}
