package me.drewhoener.Euler;

public class SelfPowers {

	public static void main(String[] args) {

		long finalNum = 0;

		for (int i = 1; i <= 1000; i++) {

			finalNum += Math.pow(i, i);
			System.out.println(i);

		}

		System.out.println(finalNum);

	}

}
