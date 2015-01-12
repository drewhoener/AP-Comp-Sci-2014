package me.lukasmetlicka.compsci.plainclass;

public class ArrayProblem {

	public static void main(String[] args) {


	}

	//returns the maximum value in the 2d parameter array a

	public static int max(int[][] a) {
		int largest = 0;
		for (int[] i : a) {
			for (int j : i) {
				if (j > largest) {
					j = largest;
				}
			}
		}
		return largest;
	}

	//returns the sum of the elements in Row x of a.
	public static int rowSum(int[][] a, int x) {
		int sum = 0;
		for (int i : a[x]) {
			sum += i;
		}
		return sum;
	}

	/*
		 Precondition: x is integer in the range of the number of rows
		 Postcondition: returns the sum of the elements in Col x of a.
	  */
	public static int columnSum(int[][] a, int x) {
		int i = 0;
		for (int j = 0; j < a.length; j++){
			i += a[j][x];
		}
		return i;
	}

	/*
	   * calculates the row sum for every row
	   * and returns each of the values in an array.
	   * index i of the return array contains the sum of elements in row i.
	  */
	public static int[] allRowSums(int[][] a) {
		int[] returnMe = new int[a.length];
		for (int i = 0; i < returnMe.length; i++){
			int sum = 0;
			for (int j : a[i]){
				sum += j;
			}
			returnMe[i] = sum;
		}
		return returnMe;
	}

	//checks if the array is row-magic (this means that every row has the same row sum).
	public static boolean isRowMagic(int[][] a) {
		boolean isMagic;
		int sum = 0;
		int sum2;
		for (int i : a[0]){
			sum += i;
		}
		for (int[] i : a){
			sum2 = 0;
			for (int j : i){
				sum2 += j;
			}
			if (sum2 != sum){
				return false;
			}
		}
		return true;
	}


	//checks if the array is col-magic (this means that every col has the same col sum).
	public static boolean isColMagic(int[][] a) {
		int col0Sum = 0;
		for (int i : a[0]){
			col0Sum += i;
		}
		int colSum;
		for (int[] i : a){
			colSum = 0;
			for (int j : i){
				colSum += j;
			}
			if (col0Sum != colSum){
				return false;
			}
		}
		return true;
	}

	/**
	 * Javadoc(Java Documentation) (tags)
	 *
	 * @param a is a square 2 dimensional array of integers, b is an integer=salary
	 * @return true if a is both row and column magic and false otherwise.
	 */
	public static boolean isMagic(int[][] a, int b) {
		return isRowMagic(a) && isColMagic(a);
	}


}
