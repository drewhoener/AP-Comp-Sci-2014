package me.drewhoener.compsci.commented.gambling;

import java.util.Random;

//Name:
public class Roulette {
	private Random rand = new Random();
	private int pocket;
	public static int numOfGames = 0;

	public Roulette() {

	}

	// Spin the roulette by
	//generating random number integer from 0-37 inclusive and
	//updating pocket and numOfGames.
	public void spin() {
		numOfGames++;
		this.pocket = rand.nextInt(38);
	}

	public void printWelcome() {
		System.out.println("Welcome to BetOnGreen,");
		System.out.print("the game where you can bet on any color as long as ");
		System.out.print("it is green.");
	}


	//determine who wins the game
	//prints out name of winner.

	//DISCLAIMER:
	//Dr. Nguyen says that a match is all the games before someone runs out of money.
	//His comments above say this is ment to print out who wins a game
	//Therefore, I use this for who wins an individual game

	public void winner(Gambler a, Gambler b) {
		//we won!
		if (this.pocket == 0 || this.pocket == 19) {
			if (a.isHouse) {
				a.loseGame();
				b.winGame();
				System.out.print("Round " + numOfGames + " winner: " + b.name);
			} else {
				System.out.print("Round " + numOfGames + " winner: " + a.name);
				a.winGame();
				b.loseGame();
			}
		} else {//aww...
			if (a.isHouse) {
				a.winGame();
				b.loseGame();
				System.out.print("Round " + numOfGames + " winner: " + a.name);
			} else {
				System.out.print("Round " + numOfGames + " winner: " + b.name);
				a.loseGame();
				b.winGame();
			}
		}
		System.out.println("\t" + a.name + " _ " + a.getBalance() + " : " + b.name + " _ " + b.getBalance());
	}


}