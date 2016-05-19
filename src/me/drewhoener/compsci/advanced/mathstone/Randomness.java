package me.drewhoener.compsci.advanced.mathstone;

import static me.drewhoener.compsci.advanced.mathstone.GraphPanel.HEIGHT;

public class Randomness {

	private double maxY = 30;
	private double minY = 5;

	public static void main(String[] args) {

		/*Scanner scanner = new Scanner(System.in);
		System.out.print("Input Percent Chance: ");
		int in = scanner.nextInt();
		double result  = 100 * Math.random();
		System.out.println("The Random Number: " + result);
		System.out.println(result <= in ? "Crit" : "No Crit");*/


		Randomness randomness = new Randomness();
		System.out.println(randomness.getYValue(15));

	}


	public double getYValue(int pointY) {

		double range = maxY - minY;
		System.out.println("Range: " + range);
		double percentage = ((pointY - minY) / range);
		System.out.println("Percent: " + percentage);

		return percentage * HEIGHT;

	}

}
