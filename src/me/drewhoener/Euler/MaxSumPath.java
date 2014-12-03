package me.drewhoener.Euler;

import java.util.ArrayList;

public class MaxSumPath {

	public static void main(String[] args) {

		int i = 75;

		ArrayList<int[]> list = new ArrayList<>();

		list.add(new int[]{75});
		list.add(new int[]{95, 64});
		list.add(new int[]{17, 47, 82});
		list.add(new int[]{18, 35, 87, 10});
		list.add(new int[]{20, 4, 82, 47, 65});
		list.add(new int[]{19, 1, 23, 75, 3, 34});
		list.add(new int[]{88, 2, 77, 73, 7, 63, 67});
		list.add(new int[]{99, 65, 4, 28, 6, 16, 70, 92});
		list.add(new int[]{41, 41, 26, 56, 83, 40, 80, 70, 33});
		list.add(new int[]{41, 48, 72, 33, 47, 32, 37, 16, 94, 29});
		list.add(new int[]{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14});
		list.add(new int[]{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57});
		list.add(new int[]{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48});
		list.add(new int[]{63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31});
		list.add(new int[]{4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23});


		int position = 0;

		for (int[] array : list) {

			if (array.length == 1) continue;

			int choice1 = moveList(position, array.length)[0];
			int choice2 = moveList(position, array.length)[1];

			if (array[choice1] > array[choice2]) {

				i += array[choice1];
				System.out.println(array[choice1]);
				position = choice1;

			} else {

				i += array[choice2];
				System.out.println(array[choice2]);
				position = choice2;
			}


		}

		System.out.println(i);


	}

	public static int[] moveList(int position, int length) {

		int[] returning = new int[2];

		if (position == 0) {
			returning[0] = 0;
			returning[1] = 1;

		} else if (position == length - 1) {

			returning[0] = length - 2;
			returning[1] = length - 1;

		} else {

			returning[0] = position;
			returning[1] = position + 1;

		}


		return returning;


	}

}
