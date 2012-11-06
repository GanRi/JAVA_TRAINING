package ch22.ex01;

public class Format {

	public static void formatDoubleArray(final double[] array, final int colNum) {
		final int totalLength = 80;

		if (colNum >= 10) {
			System.out.println("To many column");
			System.exit(0);
		}

		int columnWidth = totalLength / colNum;
		columnWidth -= 2;

		// String formatString = "%" + columnWidth + "e  ";
		final String formatString = "%e  ";

		for (int i = 0; i < array.length; i++) {
			if (i != 0 && i % colNum == 0) {
				System.out.println();
			}
			System.out.printf(formatString, array[i]);

		}
	}

	public static void main(final String[] args) {
		final double[] array = { 1.11111, 2.333333, 3.324534, 3467.436,
				Math.PI, 9.234325, 3345.346, 76495.345, Math.PI * 1000, 56.77,
				678.0, 899.1 };

		Format.formatDoubleArray(array, 4);
	}
}

