package ch22.ex06;

import java.util.Random;

public class GaussianTest {

	public static void test() {
		final int max = 3;
		final int min = -max;

		final int splitNum = 200;
		final double width = (double) (max - min) / splitNum;

		final int[] times = new int[splitNum];
		int inRangeTimes = 0;
		final Random r = new Random(System.nanoTime());

		for (int i = 0; i < 10000000; i++) {
			final double val = r.nextGaussian();
			if (val <= max && val >= min) {
				inRangeTimes++;
				times[(int) Math.floor(val / width) + splitNum / 2]++;
			}
		}
		// System.out.println(Arrays.toString(times));
		for (int i = 0; i < times.length; i++) {
			final long temp = times[i] * 10000;
			times[i] = (int) (temp / inRangeTimes);

			GaussianTest.printBar(times[i], min + i * width);
		}
		// System.out.println(Arrays.toString(times));
	}

	static private void printBar(final int count, final double val) {
		System.out.printf("%+.2f", val);
		for (int i = 0; i < count; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	public static void main(final String[] args) {
		GaussianTest.test();
	}
}
