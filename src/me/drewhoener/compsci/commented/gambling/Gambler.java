package me.drewhoener.compsci.commented.gambling;

//Name:
public class Gambler {
	String name;
	private double balance;
	boolean isHouse;


	public Gambler(String a, double b, boolean c) {
		this.name = a;
		this.balance = b;
		this.isHouse = c;
	}

	//current player wins the game
	//update their balance total
	public void winGame() {

		if (this.isHouse)
			this.balance += 1;
		else
			this.balance += 12;

	}

	//current player loses the game
	//update their balance total
	//Depending on if it's house or a player, they might lose more money
	//so we have to modify the balance specifically depending on if it's house or not
	public void loseGame() {

		if (this.isHouse)
			this.balance -= 12;
		else
			this.balance -= 1;

	}

	//Getter method for the balance, since it's private and Nguyen didn't prevent a method to
	public double getBalance() {
		return this.balance;
	}
}