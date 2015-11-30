package me.drewhoener.compsci.advanced.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilePractice {

	public static List<String> stringParts = new ArrayList<>();

	public static void main(String[] args) {


		doMath();
		System.out.println(stringParts);
		for (String s : stringParts)
			System.out.println(s + "\n");

	}

	public static void doMath() {

		long end = 0;
		long runs = 0;
		Random r = new Random();

		while (true) {
			int j = r.nextInt(2);
			end += (j == 1 ? 1 : -1);
			if (end == 0)
				System.out.println("00000000000000");
			else if ((runs % 100000000) == 0) {
				//System.out.println(runs);
				System.out.println(end);
				runs = 0;
			}
			runs++;

		}


	}

}
