package com.study.algorithm.site.backjoon.step.ch09_약수배수와소수;

import java.util.Scanner;

public class bj_11653 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();

		for (int i = 2; i <= Math.sqrt(n); i++) {
			while (n % i == 0) {
				System.out.println(i);
				n /= i;
			}
		}

		if (n != 1) {
			System.out.println(n);
		}
	}
}