package me.lukasmetlicka.compsci.plainclass.ArrayList;

import java.util.*;

public class ArrayList {

	public static void main(String[] argz){
		System.out.println("Please enter a string of words, write 'EXIT' when done.");
		Scanner console = new Scanner(System.in);
		boolean shouldLoop = true;
		String input;
		java.util.ArrayList<String> myArray = new java.util.ArrayList<String>();

		while (shouldLoop){
			input = console.nextLine();
			if (input.equals("EXIT")){
				shouldLoop = false;
			} else {
				myArray.add(input);
			}
		}

		System.out.println(myArray.toString());

	}

}
