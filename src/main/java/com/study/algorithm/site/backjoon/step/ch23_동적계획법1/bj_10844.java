package com.study.algorithm.site.backjoon.step.ch23_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_10844 {

	private static final int MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N + 1][10];

		// 초기 조건: 길이가 1인 경우
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		// 점화식 적용
		for (int n = 2; n <= N; n++) {
			for (int d = 0; d <= 9; d++) {
				if (d - 1 >= 0) {
					dp[n][d] += dp[n - 1][d - 1];
				}
				if (d + 1 <= 9) {
					dp[n][d] += dp[n - 1][d + 1];
				}
				dp[n][d] %= MOD;
			}
		}
		// 길이가 N인 계단 수들의 총합
		long result = 0;
		for (int i = 0; i <= 9; i++) {
			result = (result + dp[N][i]) % MOD;
		}

		System.out.println(result);
	}
}