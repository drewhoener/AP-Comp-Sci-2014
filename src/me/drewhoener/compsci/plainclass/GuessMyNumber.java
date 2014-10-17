package me.drewhoener.compsci.plainclass;

import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber {

    boolean running = true;

    Scanner scanner = new Scanner(System.in);
    Random r = new Random();
    int gamesPlayed = 0;
    int totalGuesses = 0;
    public static String shouldPlay = "";
    public static final int MAX_NUM = 200;


    public static void main(String[] args) {

        GuessMyNumber gmn = new GuessMyNumber();

        gmn.init();

    }

    public void init() {

        do {

            //shouldPlay = "";

            totalGuesses += playGame(scanner);

            //System.out.println(shouldPlay);


            System.out.println();
            System.out.println("Nice Going! Want to play again? (y/n): ");
            //System.out.println("Should be waiting for input");

            shouldPlay = scanner.nextLine();
            //System.out.println("\"" + shouldPlay + "\"");


        } while (shouldPlay.toLowerCase().startsWith("y") || shouldPlay.toLowerCase().startsWith("yes"));

        System.out.println();
        System.out.println("Ok, hope you had fun!");
        System.out.println("You had an average of " + (totalGuesses / gamesPlayed) + " guesses per game!");

    }

    public int playGame(Scanner scanner) {

        int numGuesses = 0;
        int guess = 0;
        int actualNum = r.nextInt(MAX_NUM) + 1;

        System.out.println("I'm thinking of a number between 1 and " + MAX_NUM + ". Can you guess what it is?");

        while (guess != actualNum) {

            System.out.println();
            System.out.print("Guess: ");
            guess = scanner.nextInt();
            scanner.nextLine();//Remove that whitespace character left over by nextInt()

            howClose(guess, actualNum);
            numGuesses++;

        }

        this.gamesPlayed++;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return numGuesses;

    }

    public void howClose(int guess, int actual) {
        int dist = Math.abs((actual - guess));

        System.out.println();
        System.out.println("Absolute: " + dist);
        System.out.println();


        if (guess != actual) {

            if (dist > 20) {
                System.out.println("Your guess is much too " + highLow(guess, actual) + "!");

            } else if (dist > 10 && dist < 20) {

                System.out.println("Your guess is too " + highLow(guess, actual) + "!");

            } else /*if(dist > actual && dist < 10)*/ {

                System.out.println("Your guess is a bit too " + highLow(guess, actual) + "!");

            }

        } else {

            System.out.println("You got it!");

        }

    }

    public String highLow(int guess, int actual) {

        if (guess > actual) {
            return "high";
        } else {
            return "low";
        }

    }
}
