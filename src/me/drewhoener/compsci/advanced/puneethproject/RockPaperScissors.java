package me.drewhoener.compsci.advanced.puneethproject;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	private int playerScore = 0;
	private int computerScore = 0;
	private int roundCounter = 0;
	private Random rand = new Random();


	public static void main(String[] args) {

		RockPaperScissors rps = new RockPaperScissors();


	}

	public RockPaperScissors() {

		Scanner scanner = new Scanner(System.in);

		while (roundCounter < 5) {
			roundCounter++;
			System.out.println("------------------------------------------------------");
			System.out.print("Enter Your Choice (R / P / S): ");
			int playerChoice = parseChoice(scanner.nextLine());
			System.out.println("------------------------------------------------------");
			int computerChoice = getComputerChoice();
			int result = this.doesPlayerWin(playerChoice, computerChoice);
			System.out.println("Round " + roundCounter + " Winner: ");
			switch (result) {
				case -1:
					System.out.println("\tComputer Wins!");
					computerScore++;
					break;
				case 0:
					System.out.println("\tTied Game!");
					break;
				case 1:
					System.out.println("\tYou Win!");
					playerScore++;
					break;
			}
			System.out.println("\t\tYour Choice: " + choiceToString(playerChoice));
			System.out.println("\t\tComputer's Choice: " + choiceToString(computerChoice));

		}

		System.out.println("------------------------------------------------------");
		if (playerScore > computerScore) {
			System.out.println();
			System.out.println("You Win!");
			System.out.println("\tYour score: " + playerScore);
			System.out.println("\tComputer Score: " + computerScore);
			System.out.println();
		} else if (playerScore < computerScore) {
			System.out.println();
			System.out.println("You Lose!");
			System.out.println("\tYour score: " + playerScore);
			System.out.println("\tComputer Score: " + computerScore);
			System.out.println();
		} else {
			System.out.println("There was no plan for this scenario...");
		}

		scanner.close();

	}

	//case is the same as if param == thing
	private int parseChoice(String str) {

		switch (str.toLowerCase()) {
			case "r":
				return 1;
			case "p":
				return 2;
			case "s":
				return 3;
			default:
				return 1;
		}

	}

	public String choiceToString(int i) {
		switch (i) {
			case 1:
				return "Rock";
			case 2:
				return "Paper";
			case 3:
				return "Scissors";
			default:
				return "Who's to say?";
		}
	}

	private int getComputerChoice() {
		return rand.nextInt(3) + 1;
	}


	//1 = Rock
	//2 = Paper
	//3 = Scissors

	/**
	 * @return 1 if player wins, -1 if computer wins, 0 if it's a tie
	 */
	private int doesPlayerWin(int playerChoice, int computerChoice) {

		if (playerChoice == 1) {

			if (computerChoice == 1)
				return 0;
			if (computerChoice == 2)
				return -1;
			if (computerChoice == 3)
				return 1;

		} else if (playerChoice == 2) {

			if (computerChoice == 1)
				return 1;
			if (computerChoice == 2)
				return 0;
			if (computerChoice == 3)
				return -1;

		} else if (playerChoice == 3) {

			if (computerChoice == 1)
				return -1;
			if (computerChoice == 2)
				return 1;
			if (computerChoice == 3)
				return 0;
		}


		return 0;
	}

}
