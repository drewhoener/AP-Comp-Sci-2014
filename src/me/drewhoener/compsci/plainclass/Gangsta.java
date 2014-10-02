package me.drewhoener.compsci.plainclass;

import java.util.Scanner;

public class Gangsta {

    Scanner scanner;

    public static void main(String[] args) {
        Gangsta g = new Gangsta();
    }

    public Gangsta() {

        this.scanner = new Scanner(System.in);

        System.out.print("Enter your full name (First, Middle, Last): ");
        String in = scanner.nextLine();

        int firstmiddlesplit = in.indexOf(" ");
        int middlelastsplit = in.indexOf(" ", firstmiddlesplit + 1);

        String first = in.substring(0, firstmiddlesplit).toUpperCase();
        String middle = in.substring(firstmiddlesplit + 1, middlelastsplit).toUpperCase();
        String last = in.substring(middlelastsplit + 1).toUpperCase();

        System.out.println(first);
        System.out.println(middle);
        System.out.println(last);

        scanner.close();

    }

}
