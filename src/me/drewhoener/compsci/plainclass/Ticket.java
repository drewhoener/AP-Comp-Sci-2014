package me.drewhoener.compsci.plainclass;

public class Ticket {

	private int number = 0;
	private double price = 0;

	public Ticket(int number) {

		this.number = number;

	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {

		return "Ticket Number: " + this.number + ", Ticket Price: " + this.price;

	}
}
