package me.drewhoener.compsci.plainclass;

import java.util.Random;
import java.util.Scanner;

public class CountingGame {

    Scanner scanner;

    public static void main(String[] args) {
        CountingGame cg = new CountingGame();
    }

    public CountingGame() {
        scanner = new Scanner(System.in);
        Random r = new Random();
        int wrongAnswers = 0;
        int correctAnswers = 0;

        while (wrongAnswers < 3) {
            int correctSum = 0;

            int numToUse = r.nextInt(3) + 2;

            for (int i = 1; i <= numToUse; i++) {

                int tmp = r.nextInt(100) + 1;

                if (i == numToUse) {
                    System.out.print(tmp + " = ");
                } else {
                    System.out.print(tmp + " + ");
                }

                correctSum += tmp;
            }

            int answer = scanner.nextInt();

            try {
                if (answer == correctSum) {
                    System.out.println();
                    System.out.println("Congrats! You got it right!");
                    System.out.println();
                    correctAnswers++;

                } else {
                    System.out.println();
                    System.out.println("Awww...You got it wrong...");
                    System.out.println();
                    wrongAnswers++;
                }

                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("You lose! You answered " + correctAnswers + " problems correctly!");

    }
}
