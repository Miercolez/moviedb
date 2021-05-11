package utility;

import static main.Main.sc;

public class Genderchoice {

    public static String chooseGender() {
        String gender;

        while (true) {

            System.out.println("Gender: ");
            System.out.println("[1] - Female");
            System.out.println("[2] - Male");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    return gender = "Female";
                case 2:
                    return gender = "Male";
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

}
