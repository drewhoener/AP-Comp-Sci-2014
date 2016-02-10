package me.drewhoener.compsci.plainclass;

import java.util.Arrays;

public class ArrayLessonSeven {

	public static void main(String[] args) {

		ArrayLessonSeven lesson = new ArrayLessonSeven();

		/*int[] tester = {-3, 0, 7, -19, 0, 2};
		lesson.zeroFront(tester);
		System.out.println(Arrays.toString(tester));
		System.out.println();
		int[] allZero = {0, 0, 0, 0, 1, 0, 0, 0, 0};
		lesson.zeroFront(allZero);
		System.out.println(Arrays.toString(allZero));
		System.out.println();


		int[] a1 = {1, 2, 3, 4, 1, 2, 3, 4, 5};
		int[] a2 = {2, 3, 4};

		lesson.zeroOut(a2, a1);
		System.out.println(Arrays.toString(a1));
		System.out.println();

		int[] array = {3, 8, 10, 1, 9, 14, -3, 0, 14, 207, 56, 98, 12};

		System.out.println(lesson.longestSortedSequence(array));
		*/

		//int[][] arr = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};
		String[][] arr = {{"Hi", "there", "AP", "CS"}, {"students!", "Do", "you", "understand"}, {"2D", "arrays", "yet?", "^_^"}};

		lesson.method(arr);
		for (String[] i : arr) {
			System.out.println(Arrays.toString(i));
		}


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

	public void zeroOut(int[] arr1, int[] arr2) {

		while (firstOccurance(arr1, arr2) != -1) {

			int index = firstOccurance(arr1, arr2);

			for (int i = 0; i < arr2.length; i++) {
				arr1[index + i] = 0;
			}

		}

	}

	public int longestSortedSequence(int a[]) {
		if (a.length == 0)
			return 0;

		int longestSequence = 1;
		int curSequence = 1;

		for (int i = 1; i < a.length; i++) {
			if (a[i] >= a[i - 1])
				curSequence++;
			else {
				if (curSequence > longestSequence)
					longestSequence = curSequence;
				curSequence = 1;
			}
		}

		return longestSequence;
	}


	/**
	 * Checks to see if the sequence of arr2 is contained in arr1
	 *
	 * @param arr1 The array checking in
	 * @param arr2 The sequence to find
	 * @return The index in the array
	 **/
	public int firstOccurance(int[] arr1, int[] arr2) {

		for (int i = 0; i < arr1.length; i++) {
			boolean flag = true;
			if (i + arr2.length >= arr1.length) {
				System.out.println("oops");
				return -1;
			}

			for (int j = 0; j < arr2.length; j++) {

				if (arr1[i + j] != arr2[j])
					flag = false;

			}

			if (flag)
				return i;
		}

		return -1;

	}

	/**
	 * Precondition: Dimensions are N x N
	 */
	public void setDiagonalsZero(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {

			arr[i][i] = 0;
			arr[i][arr.length - 1 - i] = 0;

		}

	}

	public void method(String[][] strArr) {

		String[][] result = new String[strArr.length][strArr[0].length];

		for (int col = 0; col < strArr.length; col++) {
			for (int row = 0; row < strArr[0].length; row++) {

				if (strArr[col][row].length() > 3) {
					result[col][row] = strArr[col][row].substring(strArr[col][row].length() / 2);
				} else {
					result[col][row] = strArr[col][row];
				}

			}
		}

		strArr = result;
	}


}
