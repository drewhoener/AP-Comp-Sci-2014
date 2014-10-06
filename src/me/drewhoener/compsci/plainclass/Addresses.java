package me.drewhoener.compsci.plainclass;

import java.util.Scanner;

public class Addresses {

    Scanner scanner;

    public static void main(String[] args) {

        Addresses a = new Addresses();

    }

    public Addresses() {
        scanner = new Scanner(System.in);

        System.out.print("Enter your full Address (#, Street, City, State, ZIP): ");
        String addressFull = scanner.nextLine();
        String[] addressSplit = addressFull.split("\\s*(,|\\s)\\s*");

        if (addressSplit.length == 6) {
            System.out.println("Number: " + addressSplit[0]);
            System.out.println("Street: " + addressSplit[1] + " " + addressSplit[2]);
            System.out.println("City: " + addressSplit[3]);
            System.out.println("State: " + addressSplit[4]);
            System.out.println("Zip: " + addressSplit[5]);
        } else {
            System.out.println("Wrong formatting! Correct formatting: # Street City State ZIP");
        }

    }
}
