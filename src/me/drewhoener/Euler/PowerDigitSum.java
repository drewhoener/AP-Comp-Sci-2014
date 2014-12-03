package me.drewhoener.Euler;

public class PowerDigitSum {

	public static void main(String[] args) {

		long bigNumber = 1;
		int total = 0;

		for (int i = 1; i < 1001; i++) {

			System.out.println(bigNumber);
			bigNumber *= 2;

		}

		System.out.println(bigNumber);

		/*for(int i = 0; i < Double.toString(bigNumber).length() - 5; i++){


			total += Double.parseDouble(Double.toString(bigNumber).substring(i, i + 1));


		}*/

		System.out.println(total);


	}
}
