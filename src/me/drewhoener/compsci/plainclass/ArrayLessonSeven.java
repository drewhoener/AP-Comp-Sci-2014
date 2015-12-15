package me.drewhoener.compsci.plainclass;

import java.util.Arrays;

public class ArrayLessonSeven {

	public static void main(String[] args) {

		ArrayLessonSeven lesson = new ArrayLessonSeven();

		int[] tester = {-3, 0, 7, -19, 0, 2};
		lesson.zeroFront(tester);
		System.out.println(Arrays.toString(tester));
		System.out.println();
		int[] allZero = {0, 0, 0, 0, 1, 0, 0, 0, 0};
		lesson.zeroFront(allZero);
		System.out.println(Arrays.toString(allZero));
		System.out.println();

	}

	public void zeroFront(int[] arr) {

		int swapIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = arr[swapIndex];
				arr[swapIndex] = 0;
				swapIndex++;
			}
		}

	}
}
