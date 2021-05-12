package utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Read {

    static Scanner sc = new Scanner(System.in);

    public static int readInt() {
        boolean loop = true;
        while (loop) {
            try {

                int temp = sc.nextInt();
                loop = false;
                return temp;

            } catch (InputMismatchException inputMismatchException) {

                System.out.println("Wrong input, please try again.");

                System.out.print("\nMake a choice: ");

            }finally {
                sc.nextLine();
            }
        }
        return 0;
    }

    public static Long readLong() {
        boolean loop = true;
        while (loop) {
            try {

                Long temp = sc.nextLong();
                loop = false;
                return temp;

            } catch (InputMismatchException inputMismatchException) {

                System.out.println("Wrong input, please try again.");

                System.out.print("\nMake a choice: ");

            }finally {
                sc.nextLine();
            }
        }
        return 0L;
    }

    public static double readDouble() {
        boolean loop = true;
        while (loop) {
            try {

                double temp = sc.nextDouble();
                loop = false;
                return temp;

            } catch (InputMismatchException inputMismatchException) {

                System.out.println("Wrong input, please try again.");

                System.out.print("\nMake a choice: ");

            }finally {
                sc.nextLine();
            }
        }
        return 0;
    }

    public static String readLine() {
        return sc.nextLine();
    }
}
