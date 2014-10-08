package me.drewhoener.compsci.plainclass;

import java.util.Random;

public class Dice {


    public static void main(String[] args) {
        Dice d = new Dice();
    }

    public Dice() {
        Random r = new Random();
        int tries = 0;
        int sum = 0;
        do {
            int roll1 = r.nextInt(6) + 1;
            int roll2 = r.nextInt(6) + 1;

            sum = roll1 + roll2;
            System.out.println();
            System.out.println("Roll 1: " + roll1);
            System.out.println("Roll 2: " + roll2);
            System.out.println(roll1 + " + " + roll2 + " = " + sum);
            System.out.println();

            tries++;

        } while (sum != 7);

        System.out.println("Congrats! You won after " + tries + " tries!");
    }

}
