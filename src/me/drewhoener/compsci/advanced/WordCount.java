package me.drewhoener.compsci.advanced;

import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter some text: ");
		String input = scan.nextLine();

		String[] words = input.split(" ");

		System.out.println("You had " + words.length + " words.");

	}

}
