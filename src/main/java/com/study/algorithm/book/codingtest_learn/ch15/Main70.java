package com.study.algorithm.book.codingtest_learn.ch15;

/**
 * 피보나치 수열
 */
public class Main70 {

	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(5));
	}

	private static int solution(int n) {
		int[] fibo = new int[n + 1];
		fibo[0] = 0;
		fibo[1] = 1;

		for (int i = 2; i <= n; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
		}
		return fibo[n];
	}
}
