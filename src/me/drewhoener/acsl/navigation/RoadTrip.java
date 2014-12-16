package me.drewhoener.acsl.navigation;

import java.text.DecimalFormat;
import java.util.Scanner;

public class RoadTrip {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Input (All in one line, delimated by commas): ");

		String[] input = scanner.nextLine().split(", ");

		EnumCities city1 = EnumCities.getCityByLetter(input[0]);
		EnumCities city2 = EnumCities.getCityByLetter(input[1]);

		double totalDistMiles = Math.abs(city2.getPosition() - city1.getPosition());

		EnumCars car = EnumCars.getCarByLetter(input[2]);

		double gallons = totalDistMiles / car.getMpg();

		EnumRoads road = EnumRoads.getRoadByLetter(input[3]);

		double gasCost = Double.parseDouble(input[4]);

		String totalCost = new DecimalFormat("#.00").format((gallons * gasCost));

		System.out.println("" + (int) totalDistMiles + ", " + getHours(totalDistMiles / road.speedLimit) + ":" + getMinutes(totalDistMiles / road.speedLimit) + ", $" + totalCost);


	}

	public static String getHours(double number) {

		int castNum = (int) number;
		if (number < 10) {
			return "0" + castNum;
		}

		return "" + castNum;
	}

	public static String getMinutes(double number) {

		int castNum = (int) number;
		double minutes = ((number - castNum) * 60D);

		if (Math.round(minutes) < 10) {
			return "0" + Math.round(minutes);
		}

		return "" + Math.round(minutes);
	}

}
