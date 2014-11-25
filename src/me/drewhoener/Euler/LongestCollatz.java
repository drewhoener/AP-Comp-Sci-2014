package me.drewhoener.Euler;

public class LongestCollatz {

	static int collatzNumbers = 0;
	static int largestNumCount = 0;
	static int largestStartNum = 1;

	public static void main(String[] args) {

		for (int i = 1; i <= 1000000; i++) {
			//try {


			collatzNumbers = 0;

			collatz(i);

			if (collatzNumbers > largestNumCount) {
				//System.out.println(collatzNumbers);
				//System.out.println(largestNumCount);
				largestNumCount = collatzNumbers;
				largestStartNum = i;
			}

			//}catch(StackOverflowError e){

			//e.printStackTrace();
			//break;

			//}


		}

		//collatz(13);

		System.out.println(largestStartNum);

	}


	public static void collatz(long start) {

		long startNum = start;

		if (startNum == 1) {

			collatzNumbers++;
			return;


		} else {

			collatzNumbers++;

			if (startNum % 2 == 0) {

				startNum /= 2;

			} else {

				startNum = (startNum * 3) + 1;

			}

			//System.out.println(startNum);
			collatz(startNum);

		}


	}


}
