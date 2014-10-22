package me.drewhoener.compsci.plainclass;

import java.util.Random;
import java.util.Scanner;

public class BinderCheckMethods {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //longestName(scanner, 7);
        //threeHeads();

        System.out.println(graduation(3.87, 178, 16));
        System.out.println(graduation(1.5, 199, 30));
        System.out.println(graduation(2.7, 380, 50));
        System.out.println(graduation(3.6, 180, 14));
        System.out.println(graduation(3.62, 200, 20));
        System.out.println(graduation(3.93, 185, 0));
        System.out.println(graduation(3.85, 190, 15));

    }

    public static void longestName(Scanner scanner, int number) {

        String[] strings = new String[number];
        int maxLength = 0;

        for (int i = 0; i < number; i++) {

            System.out.print("Name #" + (i + 1) + ": ");

            strings[i] = scanner.nextLine();

            if (maxLength < strings[i].length()) {
                maxLength = strings[i].length();
            }
            System.out.println();

        }

        int arraySize = 0;

        for (int i = 0; i < strings.length; i++) {

            if (strings[i].length() >= maxLength) {
                arraySize++;

            }

        }

        int[] stringLoc = new int[arraySize];

        int temp = 0;

        for (int i = 0; i < strings.length; i++) {

            if (strings[i].length() >= maxLength) {
                stringLoc[temp] = i;
                temp++;
            }


        }

        System.out.println("The longest name is: " + strings[stringLoc[0]].substring(0, 1).toUpperCase() + strings[stringLoc[0]].substring(1).toLowerCase());
        if (stringLoc.length > 1) {
            System.out.println("With a tie.");
        }


    }


    public static void threeHeads() {

        System.out.println();
        Random r = new Random();

        String[] strings = new String[3];

        for (int i = 0; i < 3; i++) {

            int temp = r.nextInt(2);

            if (temp == 0) {
                strings[i] = "T";

            } else {
                strings[i] = "H";

            }

        }

        System.out.print(strings[0] + " ");
        System.out.print(strings[1] + " ");
        System.out.print(strings[2] + " ");

        while (!(strings[0].equalsIgnoreCase("H") && strings[1].equalsIgnoreCase("H") && strings[2].equalsIgnoreCase("H"))) {

            strings[0] = strings[1];
            strings[1] = strings[2];

            int temp = r.nextInt(2);

            if (temp == 0) {

                strings[2] = "T";

            } else {

                strings[2] = "H";

            }

            System.out.print(strings[2] + " ");


        }

        System.out.println();
        System.out.println("Three Heads in a row!");

    }


    //Might be a little redundant
    public static String graduation(double GPA, int totalCredit, int honorCredit) {

        if (GPA >= 2.0 && totalCredit >= 180) {

            if (GPA >= 3.6 && GPA < 3.8) {

                if (honorCredit < 15 && honorCredit >= 0) {

                    return "Graduating cum laude";

                } else {

                    return "Graduating magna cum laude";

                }

            }

            if (GPA >= 3.6 && GPA < 3.8) {

                if (honorCredit >= 15) {

                    return "Graduating magna cum laude";

                }

            }


            if (GPA >= 3.8) {

                if (honorCredit >= 15) {

                    return "Graduating summa cum laude";

                } else {

                    return "Graduating magna cum laude";

                }

            }

            return "Graduating";


        } else {

            return "Not Graduating";

        }

    }

}
