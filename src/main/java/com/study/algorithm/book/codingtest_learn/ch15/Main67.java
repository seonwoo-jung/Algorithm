package com.study.algorithm.book.codingtest_learn.ch15;

import java.util.Arrays;

/**
 * LCS
 */
public class Main67 {

	public static void main(String[] args) {
		System.out.println(solution("ABCBDAB", "BDCAB"));
	}

	private static int solution(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];

		// i는 str1의 접두사 길이라고 생각
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// 두 문자가 동일하면 이전 두 접두사에 대한 길이에 +1을 한다.
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				// 두 문자가 다르면 이전 두 접두사 중 큰 값을 넣는다.
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		for (int[] ints : dp) {
			System.out.println(Arrays.toString(ints));
		}

		return dp[m][n];
	}
}
