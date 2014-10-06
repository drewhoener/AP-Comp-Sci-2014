package me.drewhoener.compsci.commented;

import java.util.Scanner;

public class AddressCommented {

    Scanner scanner;

    public static void main(String[] args) {
        AddressCommented ac = new AddressCommented();
    }

    public AddressCommented() {
        scanner = new Scanner(System.in);

        System.out.print("Address: ");
        String line = scanner.nextLine();

        int num = line.indexOf(" ");
        String number = line.substring(0, num);

        int streetNameNum = line.indexOf(" ", num + 1);
        int streetTypeNum = line.indexOf(" ", streetNameNum + 1);

        String streetName = line.substring(num, streetTypeNum);

        int cityNum = line.indexOf(" ", streetTypeNum + 1);

        String cityName = line.substring(streetTypeNum, cityNum - 1);

        int stateNum = line.indexOf(" ", cityNum + 1);

        String stateName = line.substring(cityNum, stateNum);

        int zipNum = line.indexOf(" ", stateNum);

        String zipName = line.substring(zipNum);


        System.out.println("Number: " + number);
        System.out.println("Street: " + streetName);
        System.out.println("City: " + cityName);
        System.out.println("State: " + stateName);
        System.out.println("Zip: " + zipName);
    }
}
