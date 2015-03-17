package me.drewhoener.compsci.plainclass;

public class MatrixModify {


	public static void main(String[] args) {

		MatrixModify matrixModify = new MatrixModify();

		Integer[][] matrix = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, 9}};

		String[][] matrix1 = {{"Hello", "Hi", "Yo"}, {"Heyyy", "Hola", "Entry 3"}, {"More", "Entries", "Here"}};

		Character[][] charArray = {{'A', 'B', 'C', 'D', 'E'}, {'F', 'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N', 'O'}, {'P', 'Q', 'R', 'S', 'T'}, {'U', 'V', 'W', 'X', 'Y'}};

		matrixModify.printArray(charArray);
		System.out.println();
		System.out.println();
		matrixModify.copyDiagonalRightLeft(charArray);
		matrixModify.printArray(charArray);
		System.out.println();
		System.out.println();


	}

	public <T extends Object> void printArray(T[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf(a[i][j] + "\t");
			}
			System.out.println();
		}
	}


	public <T extends Object> void copyVerticalRightLeft(T[][] list) {

		for (int i = 0; i < list.length; i++) {

			for (int j = list[i].length - 1; j > 0; j--) {

				list[i][list[i].length - 1 - j] = list[i][j];

			}


		}


	}

	public <T extends Object> void copyVerticalLeftRight(T[][] list) {

		for (int i = 0; i < list.length; i++) {

			for (int j = list[i].length - 1; j > 0; j--) {

				list[i][j] = list[i][list[i].length - 1 - j];

			}

		}

	}

	public <T extends Object> void copyHorizontalTopBottom(T[][] list) {

		for (int i = 0; i < list.length / 2; i++) {

			for (int j = 0; j < list[i].length; j++) {

				list[list.length - 1 - i][j] = list[i][j];

			}

		}

	}

	public <T extends Object> void copyHorizontalBottomTop(T[][] list) {

		for (int i = 0; i < list.length / 2; i++) {

			for (int j = 0; j < list[i].length; j++) {

				list[i][j] = list[list.length - 1 - i][j];

			}

		}

	}

	public <T extends Object> void copyDiagonalRightLeft(T[][] list) {

		for (int i = 0; i < list.length; i++) {

			for (int j = i + 1; j < list[i].length; j++) {

				list[j][i] = list[i][j];

			}

		}

	}


}
