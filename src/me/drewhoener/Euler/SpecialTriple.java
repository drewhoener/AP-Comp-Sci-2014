package me.drewhoener.Euler;

public class SpecialTriple {

	public static void main(String[] args) {


		for (int a = 1; a < 600; a++) {


			for (int b = 1; b < 600; b++) {

				for (int c = 1; c < 600; c++) {

					if ((a * a + b * b) == (c * c)) {

						System.out.println((a * a + b * b) + " = " + (c * c));
						System.out.println("\t" + (a + b + c));

						if ((a + b + c) == 1000) {
							System.out.println("Answer: " + (a * b * c));
							System.exit(0);
						}

					}


				}

			}


		}


	}

}
