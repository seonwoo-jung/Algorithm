package com.study.algorithm.book.codingtest_learn.ch15;

/**
 * 조약돌 문제
 */
public class Main69 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1, 3, 3, 2}, {2, 1, 4, 1}, {1, 5, 2, 3}}));
		System.out.println(solution(new int[][]{{1, 7, 13, 2, 6}, {2, -4, 2, 5, 4}, {5, 3, 5, -3, 1}}));
	}

	private static int solution(int[][] arr) {
		int n = arr[0].length;

		int[][] dp = new int[4][n];

		// 패턴 저장
		// 0: 상단, 1: 중앙, 2: 하단, 3: 상단과 하단
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		dp[2][0] = arr[2][0];
		dp[3][0] = arr[0][0] + arr[2][0];

		for (int i = 1; i < n; i++) {
			// 패턴 0이 선택된 경우, 이전 패턴
			dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[2][i - 1]);
			// 패턴 1이 선택된 경우, 이전 패턴
			dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], Math.max(dp[2][i - 1], dp[3][i - 1]));
			// 패턴 2이 선택된 경우, 이전 패턴
			dp[2][i] = arr[2][i] + Math.max(dp[0][i - 1], dp[1][i - 1]);
			// 패턴 3이 선택된 경우, 이전 패턴
			dp[3][i] = arr[0][i] + arr[2][i] + dp[1][i - 1];
		}

		// 최대 가중치 찾아서 반환
		return Math.max(Math.max(dp[0][n - 1], dp[1][n - 1]), Math.max(dp[2][n - 1], dp[3][n - 1]));
	}
}
