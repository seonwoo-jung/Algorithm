package com.study.algorithm.book.codingtest_learn.ch15;

/**
 * LCS
 */
public class Main67 {

	public static void main(String[] args) {
		int solution = solution("ABCBDAB", "BDCAB");
		System.out.println("solution = " + solution);
	}

	private static int solution(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}
}
