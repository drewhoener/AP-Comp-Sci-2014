package me.drewhoener.compsci.advanced;

import java.util.Random;
import java.util.Scanner;

public class RemoveInteger {

	public static void main(String[] args) {

		Testing1 test = new Testing1();


	}


}

class Testing1 {


	Scanner scan = new Scanner(System.in);

	public Testing1() {
		run();
	}

	public void run() {

		System.out.println(apcsReplaceAll("to be or not to be", "2", "to"));

	}

	public String apcsReplaceAll(String mainStr, String newPart, String toReplace) {

		String toReturn = "";

		while (mainStr.length() > 0) {

			toReturn += mainStr.substring(0, mainStr.indexOf(toReplace)) + newPart;
			mainStr = mainStr.substring(mainStr.indexOf(toReplace) + mainStr.length());

		}

		return toReturn;
	}


}


class RandomName {
	public String goal;
	private int counter;
	public final String[] letters = {" ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	public Random rand = new Random();

	public RandomName(String a) {
		goal = a;
	}

	public int findGoal() {
		String tryer = " ";
		while (!tryer.equalsIgnoreCase(goal)) {
			tryer += letters[rand.nextInt(26)];
			if (tryer.length() > goal.length())
				tryer = " ";
			//System.out.println(tryer);
			counter++;
		}
		System.out.println(tryer);
		return counter;
	}

}
