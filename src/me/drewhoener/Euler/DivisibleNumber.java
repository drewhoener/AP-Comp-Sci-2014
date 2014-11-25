package me.drewhoener.Euler;

public class DivisibleNumber {

	public static void main(String[] args) {

		int num = 0;

		for (int i = 1; ; i++) {

			int tmp = 0;


			for (int j = i; j > 0; j--) {

				tmp += j;

			}


			num = tmp;
			if (numDivisors(num) >= 500) {
				break;
			}


		}

		System.out.println(num);


	}

	public static int numDivisors(int num) {

		int numDivisors = 0;

		for (int i = 1; i <= num; i++) {

			if (num % i == 0) {

				numDivisors++;

			}

		}

		System.out.println(num + " has " + numDivisors + " divisors");


		return numDivisors;
	}


}
