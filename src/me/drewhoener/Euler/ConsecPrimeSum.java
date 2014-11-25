package me.drewhoener.Euler;

import me.drewhoener.compsci.plainclass.Primes;

import java.util.ArrayList;

public class ConsecPrimeSum {

	static boolean debug = true;

	public static void main(String[] args) {
		Primes primes = new Primes();
		ConsecPrimeSum s = new ConsecPrimeSum();
		ArrayList<Integer> list = new ArrayList<>();

		//System.out.println(s.primeSumBelow(1000000));
		//List<Integer> list = primes.getPrimes(1000000);

		long num = 0;
		long largestConsec = 2;
		boolean breakIt = false;

		for (int i = 3; i < 1000000; i++) {


			if (isPrime(i)) {
				largestConsec += i;

				if (largestConsec > 1000000) {
					break;
				}


				if (isPrime((int) largestConsec)) {
					list.add((int) largestConsec);
				}


			}


		}


		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		int largest = 0;

		for (int i = 0; i < list.size(); i++) {

			if (isPrime(list.get(i))) {
				if (list.get(i) > largest) ;
				largest = list.get(i);
			}

		}

		System.out.println(largest);

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(isPrime(958577));

	}

	public static boolean isPrime(int num) {

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
