package me.drewhoener.compsci.commented.gambling;//Name:

/* The Roulette wheel has 38 pockets numbered 0-37.
 * 0 and 19 Green.
 * 1-18 Red
 * 20-37 Black
 * Simulate one match between a player and the house.
 * Player will always bet $1 on Green. 
 * Player wins $12 if ball lands on Green.
 * Player loses $1 if ball lands on either Red or Black.
 * Both the house and the player starts out with $50.
 * Match ends when the player or the house lost all of his money.
 * You MUST USE BetOnGreen, Gambler, Roulette Java files.
 * You can add to the code but can not remove any code.
 * 
 * MODIFY: Once the game works. Simulate 100 matches and count the number 
 * of times the player wins. 
 */


public class BetOnGreen {

	public static void main(String[] args) {
		Roulette g = new Roulette();
		Gambler player = new Gambler("Mike", 50, false);
		Gambler house = new Gambler("Foxwoods", 50, true);

		//print welcoming screen from Roulette class.
		//using the instance of Roulette that we created above
		//made Nguyen's methods non-static
		g.printWelcome();


		//play the match
		//we have to play while they both have money left
		while (player.getBalance() > 0 && house.getBalance() > 0) {
			g.spin();
			g.winner(player, house);
		}


		//prints out the name of the winner of the match
		//and the number of games. Must call winner method.

		System.out.println();
		if (player.getBalance() <= 0) {
			System.out.println("Winner: " + house.name);
		} else {
			System.out.println("Winner: " + player.name);
		}
		System.out.println("\tMatches: " + Roulette.numOfGames);


	}


}