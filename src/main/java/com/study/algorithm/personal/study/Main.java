package com.study.algorithm.personal.study;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int a = kb.nextInt();
		int b = kb.nextInt();
		int l = 100;
		int sum1 = 0;
		int sum2 = 0;
		while (a > 0 || b > 0) {
			sum1 += a % 10 * l;
			sum2 += b % 10 * l;

			a = a / 10;
			b = b / 10;

			l /= 10;

		}

		System.out.println(Math.max(sum1, sum2));
	}
}
