package utility;

import static utility.Read.*;

public class GenderChoice {

    public static String chooseGender() {
        String gender;

        while (true) {

            System.out.println("Gender: ");
            System.out.println("[1] - Female");
            System.out.println("[2] - Male");
            int choice = readInt();

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
