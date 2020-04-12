package lab06;

import java.security.SecureRandom;

public class Lab6 {

	private static final int TOTAL_NUMBERS = 100;
	private static final int NUMBER_OF_RANGES = 6;

	private static void print(String output, int iter) {
		System.out.print("\n" + output + " ");
		for (int i = 0; i < iter; i++) {
			System.out.print("*");
		}

	}

	public static void main(String[] args) {
		SecureRandom secure = new SecureRandom();
		int maxTemp = Integer.MIN_VALUE;
		int minTemp = Integer.MAX_VALUE;
		int[] temperatureData = new int[TOTAL_NUMBERS];
		int sum = 0;
		double averageTemp = 0.0;
		int[] frequencyOfTemp = new int[NUMBER_OF_RANGES];
		for (int i = 0; i < TOTAL_NUMBERS; i++) {
			int value = secure.nextInt(41 - (-40)) - 40;
			temperatureData[i] = value;
			sum += value;

			if (value > maxTemp) {
				maxTemp = value;
			} else if (value < minTemp) {
				minTemp = value;
			}

			if (value < -10) {
				frequencyOfTemp[0] += 1;
			} else if (value < 0) {
				frequencyOfTemp[1] += 1;
			} else if (value < 10) {
				frequencyOfTemp[2] += 1;
			} else if (value < 20) {
				frequencyOfTemp[3] += 1;
			} else if (value < 30) {
				frequencyOfTemp[4] += 1;
			} else {
				frequencyOfTemp[5] += 1;
			}

		}

		averageTemp = (double) sum / (double) TOTAL_NUMBERS;

		System.out.println("Maximum temperature: " + maxTemp);
		System.out.println("Minimum temperature: " + minTemp);
		System.out.println("Average temperature: " + averageTemp);
		System.out.println("\nFrequency of Temperature Ranges: ");

		print("Less than -10", frequencyOfTemp[0]);
		print("-10 to 0", frequencyOfTemp[1]);
		print("0 to 10", frequencyOfTemp[2]);
		print("10 to 20", frequencyOfTemp[3]);
		print("20 to 30", frequencyOfTemp[4]);
		print("Greater than 30", frequencyOfTemp[5]);

	}

}
