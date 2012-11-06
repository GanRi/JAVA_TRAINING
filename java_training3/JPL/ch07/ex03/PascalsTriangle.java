package ch07.ex03;

public class PascalsTriangle {
	public static void main(String[] args) {
		final int LEVLE = 12;
		int[][] pascalsTriangle = new int[LEVLE][];

		pascalsTriangle[0] = new int[] { 1 };
		for (int i = 1; i < LEVLE; i++) {
			pascalsTriangle[i] = new int[i + 1];
			for (int j = 0; j < pascalsTriangle[i].length; j++) {
				int leftComponent, rightComponent;

				if (j == 0) {
					leftComponent = 0;
				} else {
					leftComponent = pascalsTriangle[i - 1][j - 1];
				}

				if (j == pascalsTriangle[i].length - 1) {
					rightComponent = 0;
				} else {
					rightComponent = pascalsTriangle[i - 1][j];
				}

				pascalsTriangle[i][j] = leftComponent + rightComponent;
			}
		}

		print(pascalsTriangle);
	}

	public static void print(int[][] pascalsTriangle) {
		for (int i = 0; i < pascalsTriangle.length; i++) {
			for (int j = 0; j < pascalsTriangle[i].length; j++) {
				System.out.print(pascalsTriangle[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
