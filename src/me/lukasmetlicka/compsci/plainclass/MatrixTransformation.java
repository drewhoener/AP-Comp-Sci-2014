package me.lukasmetlicka.compsci.plainclass;

import java.util.*;

public class MatrixTransformation {

	public static void main(String[] args) {

		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

		System.out.println("Vertical Left to Right:");
		mirrorVerticalLeftToRight(matrix);
		printArray(matrix);


		System.out.println("Vertical Right To Left:");
		mirrorVerticalRightToLeft(matrix);
		printArray(matrix);


		System.out.println("Horizontal Top To Bottom:");
		mirrorHorizontalTopToBottom(matrix);
		printArray(matrix);


		System.out.println("Horizontal Bottom To Top");
		mirrorHorizontalBottomToTop(matrix);
		printArray(matrix);

		System.out.println("Diagonal Right To Left");
		mirrorDiagonalRightToLeft(matrix);
		printArray(matrix);


	}

	public static void printArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void mirrorVerticalLeftToRight(int[][] a) {

		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[0].length/2; j++){

				a[i][a.length - (1 + j)] = a[i][j];

			}
		}

	}

	public static void mirrorVerticalRightToLeft(int[][] a) {

		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[0 ].length/2; j++){

				a[i][j] = a[i][a.length - (1 + j)];

			}
		}

	}

	public static void mirrorHorizontalTopToBottom(int[][] a) {

		for (int i = 0; i < a.length/2; i++){
			for (int j = 0; j < a.length; j++){

				a[a.length - (1 - i)][j] = a[i][j];

			}
		}

	}

	public static void mirrorHorizontalBottomToTop(int[][] a) {

		for (int i = 0; i < a.length/2; i++){
			for (int j = 0; j < a.length; j++){

				a[i][j] = a[a.length - (1 - i)][j];

			}
		}

	}

	public static void mirrorDiagonalRightToLeft(int[][] a) {

		for (int i = 0; i < a.length/2; i++){
			for (int j = 0; j < a[0].length/2; j++){

				a[i][j] = a[a.length - (1 + i)][a.length - (1 + j)];

			}
		}

	}


}



