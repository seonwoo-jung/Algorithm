package com.study.algorithm.site.backjoon.step.ch23_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_9416 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N + 1];
			dp[0] = 0L;
			dp[1] = 1L;

			if (N > 1) {
				dp[2] = 1L;
				for (int j = 3; j <= N; j++) {
					dp[j] = dp[j - 3] + dp[j - 2];
				}
			}
			System.out.println(dp[N]);
		}
	}
}