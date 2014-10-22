package me.drewhoener.compsci.plainclass;

import java.util.Arrays;
import java.util.Scanner;

public class TemperatureArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What were the temperatures?");
        String[] strings = scanner.nextLine().split(" ");
        double[] temperatures = new double[strings.length];

        for (int i = 0; i < strings.length; i++) {

            try {
                temperatures[i] = Double.parseDouble(strings[i]);
            } catch (Exception e) {

                e.printStackTrace();
                System.out.println("You entered things that weren't numbers! Shame on you!");

            }

        }

        double avg = 0;

        Arrays.sort(temperatures);

        System.out.print("Your temperatures: ");

        for (int i = 0; i < temperatures.length; i++) {

            avg += temperatures[i];

            System.out.print(temperatures[i] + " ");

        }

        System.out.println();

        avg /= temperatures.length;

        System.out.println("Temperature Average: " + avg);


        int days = 0;

        for (int i = 0; i < temperatures.length; i++) {

            if (temperatures[i] > avg) {
                days++;
            }

        }

        System.out.print("Number of days above average: " + days);

        System.out.println();

        System.out.println("Two Hottest Days: " + temperatures[temperatures.length - 1] + ", " + temperatures[temperatures.length - 2]);
        System.out.println("Two Coldest Days: " + temperatures[0] + ", " + temperatures[1]);


    }
}
