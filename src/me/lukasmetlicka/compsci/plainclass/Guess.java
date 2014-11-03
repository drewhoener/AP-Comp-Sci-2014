package me.lukasmetlicka.compsci.plainclass;// This program plays a simple guessing game with the user.

import java.util.*;

public class Guess {
    public static final int MAX_GUESS = 100; //user will guess number from 1 to MAX_GUESS=100

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Guess g = new Guess();
        giveIntro();
        int numGames = 0;  // total number of games user play
        int totGuesses = 0; // total number of guesses in all games played
        // while or do while loop
        // Call playGame to play one game.
        // ask if user wants to play again.
        // update numGames and totGuesses.
        String sysInput = "";
        while ( !sysInput.equalsIgnoreCase("Y") && !sysInput.equalsIgnoreCase("Yes") ){
          
          if ( numGames > 0 ){
           System.out.println("Would you like to play again?");
           sysInput = console.nextLine(); 
           if ( sysInput.equalsIgnoreCase("Y") || sysInput.equalsIgnoreCase("Yes") ){
             sysInput = "";
            totGuesses += g.playGame(console);
            numGames++;
           }
           else if ( sysInput.equalsIgnoreCase("n") || sysInput.equalsIgnoreCase("no") ){
            break; 
           }
          }
          else if (numGames == 0 ){
          totGuesses += g.playGame(console);
          numGames++;
          }
          
        }
        
        
        
        
        
        
        //once user is done playing, report results.
        reportResults(numGames, totGuesses);
    }

    public static void giveIntro() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and " + MAX_GUESS);
        System.out.println("and will allow you to guess until you get it.");
        System.out.println("For each guess, I will tell you whether the");
        System.out.println("right answer is higher or lower than your guess.");
        System.out.println();
    }

    // play one game, return number of guesses user took to get right answer.
    public static int playGame(Scanner console) {
        Random r = new Random();
        int myRand = r.nextInt(99) +1;
        int guess = -1;
        int numGuesses = 0;
        System.out.println("I'm thinking of a number...");
        while (guess != myRand){
        guess = console.nextInt();
        if ( guess > myRand ){
         System.out.println("try a little lower"); 
         numGuesses++;
        }
        else {
         System.out.println("Try a little higher"); 
         numGuesses++;
        }
        }
        
        System.out.println("You got it right in " + numGuesses + " guesses");
        System.out.println();
        return numGuesses;
    }

    // report total games, total guesses and average guess per game.
    public static void reportResults(int numGames, int totGuesses) {
        System.out.println("Overall results:");
        System.out.println("Number of Games:\t" + numGames);
        System.out.println("Total Guesses:\t" + totGuesses);
    }
}