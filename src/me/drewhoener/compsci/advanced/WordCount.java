package me.drewhoener.compsci.advanced;

public class WordCount {

	public static void main(String[] args) {

		/*Scanner scan = new Scanner(System.in);

		System.out.print("Enter some text: ");
		String input = scan.nextLine();

		String[] words = input.split(" ");

		System.out.println("You had " + words.length + " words.");*/

		/*System.out.println("(1, 3) -> " + getTableAdjustment(1, 3));
		System.out.println("(2, 3) -> " + getTableAdjustment(2, 3));
		System.out.println("(3, 3) -> " + getTableAdjustment(3, 3));

		System.out.println();
		System.out.println();

		System.out.println("(1, 2) -> " + getTableAdjustment(1, 2));
		System.out.println("(2, 2) -> " + getTableAdjustment(2, 2));
		System.out.println("(3, 2) -> " + getTableAdjustment(3, 2));

		System.out.println();
		System.out.println();

		System.out.println("(1, 1) -> " + getTableAdjustment(1, 1));
		System.out.println("(2, 1) -> " + getTableAdjustment(2, 1));
		System.out.println("(3, 1) -> " + getTableAdjustment(3, 1));
		*/

		for (EnumDistributor value : EnumDistributor.values()) {

			System.out.println(value.toString());
			System.out.println("\tInput: " + value.getWeightMultiplier());
			System.out.println("\tOutput: " + getTableAdjustment(value.getWeightMultiplier(), 1));

		}

	}

	public static int getTableAdjustment(int wA, int pA) {

		switch (pA) {
			case 1:
				return Math.abs(((pA << wA) + (wA * pA)) - (2 * (wA + (2 * ((wA * pA) ^ (pA ^ wA)) * (pA & wA)))));
			case 2:
				return ((wA * pA) - ((wA - 1) * pA)) - ((2 * (pA ^ wA) - 1) * ((pA & wA) / 2));
			case 3:
				return ((wA << pA) / 8);
			default:
				return 1;
		}

	}

}
