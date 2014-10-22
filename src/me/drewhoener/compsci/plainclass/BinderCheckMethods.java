package me.drewhoener.compsci.plainclass;

import java.util.Scanner;

public class BinderCheckMethods {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        longestName(scanner, 7);

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


    }

}
