package com.study.algorithm.inflearn.middle.ch09_dp.intro;

public class Main1_계단오르기 {

	private static int[] dp;

	public static void main(String[] args) {
		System.out.println(solution(7));
	}

	private static int solution(int n) {
		dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n - 1];
	}
}
