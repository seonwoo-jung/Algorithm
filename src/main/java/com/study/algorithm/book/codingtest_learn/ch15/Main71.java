package com.study.algorithm.book.codingtest_learn.ch15;

/**
 * 2 * n 타일링
 */
public class Main71 {

	public static void main(String[] args) {
		System.out.println(solution(4));
	}

	private static int solution(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 2;

		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		return dp[n - 1];
	}
}
