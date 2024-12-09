package com.study.algorithm.personal.study;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		double[] changes = new double[]{0.25, 0.10, 0.05, 0.01};

		for (int i = 0; i < t; i++) {
			int c = kb.nextInt();

			for (int j = 0; j < changes.length; j++) {
				int changeInCents = (int) (changes[j] * 100);

				int result = c / changeInCents;
				System.out.printf("%d ", result);

				c = c % changeInCents;
			}
			System.out.println();
		}
	}
}