package com.study.algorithm.site.backjoon;

import java.util.Scanner;

public class bj_1978 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int answer = 0;

		for (int i = 0; i < n; i++) {
			int k = kb.nextInt();
			if (isPrime(k)) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static boolean isPrime(int k) {
		if (k == 1) return false;

		for (int i = 2; i < k; i++) {
			if (k % i == 0) {
				return false;
			}
		}
		return true;
	}
}