package Menus;

import static main.Main.sc;

public class ActorMenu {
    private static void actorMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--|| Actor menu ||--");
//        System.out.println("[1] - Add actor");
//        System.out.println("[2] - Change name");
//        System.out.println("[3] - Change age");
//        System.out.println("[4] - Change gender");
//        System.out.println("[5] - Delete actor");
//        System.out.println("[6] - Show all actors");
//        System.out.println("[0] - Return to main");

            System.out.print("\nMake a choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:

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
}
