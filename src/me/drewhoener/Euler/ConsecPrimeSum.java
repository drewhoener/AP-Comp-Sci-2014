package me.drewhoener.Euler;

import me.drewhoener.compsci.plainclass.Primes;

import java.util.List;

public class ConsecPrimeSum {

	boolean debug = true;

	public static void main(String[] args) {
		Primes primes = new Primes();
		ConsecPrimeSum s = new ConsecPrimeSum();

		//System.out.println(s.primeSumBelow(1000000));
		List<Integer> list = primes.getPrimes(1000000);

		long num = 0;
		long largestConsec = 0;
		boolean breakIt = false;

		for (int i : list) {

			System.out.println();
			System.out.println("Num: " + num);
			System.out.println("I: " + i);

			long tmp = i + num;

			System.out.println("Tmp: " + tmp);
			System.out.println();

			if (primes.isPrime(num)) {

				if (num < 1000000) {
					largestConsec = num;
				}

			}

			if (breakIt) break;

			num = tmp;

		}

		System.out.println(largestConsec);

	}

	public boolean isPrime(int num) {

		System.out.println("checking num " + num);

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				if (debug) System.out.println("returning false: " + i);
				System.out.println();
				return false;
			}
		}
		return true;
	}

	public int primeSumBelow(long beforeNum) {

		int returnNum = 2;

		for (int i = 3; ; i++) {

			if (isPrime(i)) {

				int tempNum = returnNum + i;

				if (tempNum > beforeNum) {
					if (isPrime(returnNum)) {
						break;
					}
				} else {
					System.out.println("num = " + (returnNum + i));
					returnNum += i;
				}

			}

		}

		return returnNum;
	}


}
