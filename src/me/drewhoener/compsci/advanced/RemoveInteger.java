package me.drewhoener.compsci.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RemoveInteger {

	public static void main(String[] args) {

		int sum = 0;

		for (int i = 0; i < 7; i++) {

			sum += ((4 * i) + 1);

		}

		System.out.println(sum);

	}


}

class Testing1 {


	Scanner scan = new Scanner(System.in);

	public Testing1() {
		run();
	}

	public void run() {

		this.doThing(6, 3);

	}

	public String apcsReplaceAll(String mainStr, String newPart, String toReplace) {

		String toReturn = "";

		while (mainStr.length() > 0) {

			toReturn += mainStr.substring(0, mainStr.indexOf(toReplace)) + newPart;
			mainStr = mainStr.substring(mainStr.indexOf(toReplace) + mainStr.length());

		}

		return toReturn;
	}

	public void doThing(int a, int b) {

		a *= b;
		b *= a;
		System.out.println(a + " " + b);

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

class RouteCipher {

	private String[][] letterBlock = new String[2][3];
	private int numRows = 2;
	private int numCols = 3;

	private void fillBlock(String str) {

		System.out.println(str);
		System.out.println();

		for (int i = 0; i < this.letterBlock.length; i++) {

			for (int j = 0; i < this.letterBlock[i].length; j++) {

				int curPos = (this.letterBlock.length * i) + j;
				System.out.println(this.letterBlock.length);
				System.out.println(j);
				System.out.println(curPos);

				if (curPos <= str.length()) {

					this.letterBlock[i][j] = str.substring(curPos, curPos + 1);

				} else {

					this.letterBlock[i][j] = "A";

				}

			}

		}

	}

	private String encryptBlock() {
		String returnStr = "";

		for (int i = 0; i < this.numCols; i++) {

			for (int j = 0; j < this.numRows; j++) {

				returnStr += this.letterBlock[j][i];

			}

		}

		return returnStr;
	}

	public String encryptMessage(String message) {

		String returnStr = "";
		int size = this.numCols * this.numRows;

		for (int i = 0; i < message.length() / size + 1; i++) {

			if (i * size + (size - 1) >= message.length()) {

				this.fillBlock(message.substring(i * size));

			} else {

				this.fillBlock(message.substring(i * size, i * size + (size - 1)));

			}

			returnStr += this.encryptBlock();

		}

		return returnStr;
	}

}


class Tourney {


	Player[] list = new Player[100];
	List<String> waiting = new ArrayList<>();

	public Player requestSlot(String name) {
		boolean free = false;
		for (int i = 0; i < list.length; i++) {

			if (list[i] == null) {

				list[i] = new Player(name, i);
				return list[i];

			}

		}

		waiting.add(name);
		return null;

	}


}

class Player {


	public Player(String name, int position) {


	}


}
