package ch22.ex05;

import java.util.Random;

public class Probability {
	public static double calculateProbability(final int diceNumber,
			final int desiredTotalScore) {
		final int MAX_TOTAL = 6;

		int times = 0;
		final int totalTimes = 10000000;
		final Random r = new Random(System.nanoTime());
		for (int i = 0; i < totalTimes; i++) {
			int total = 0;
			for (int j = 0; j < diceNumber; j++) {
				total += r.nextInt(MAX_TOTAL) + 1;
			}

			if (total == desiredTotalScore) {
				times++;
			}
		}

		return (double) times / totalTimes;

	}

	public static void main(final String[] args) {
		int diceNumber = 2;
		int desiredTotalScore = 7;
		System.out.printf("%d dices, score %d is desired, probability = %f%n",
				diceNumber, desiredTotalScore, Probability
						.calculateProbability(diceNumber, desiredTotalScore));

		diceNumber = 2;
		desiredTotalScore = 12;
		System.out.printf("%d dices, score %d is desired, probability = %f%n",
				diceNumber, desiredTotalScore, Probability
						.calculateProbability(diceNumber, desiredTotalScore));

		diceNumber = 3;
		desiredTotalScore = 10;
		System.out.printf("%d dices, score %d is desired, probability = %f%n",
				diceNumber, desiredTotalScore, Probability
						.calculateProbability(diceNumber, desiredTotalScore));

	}
}
