package com.study.algorithm.book.codingtest_learn.ch15;

import java.util.Arrays;

/**
 * LIS
 */
public class Main68 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 4, 2, 3, 1, 5, 7, 3}));
		System.out.println(solution(new int[]{3, 2, 1}));
	}

	private static int solution(int[] nums) {
		int n = nums.length;

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					System.out.println(Arrays.toString(dp));
					dp[i] = Math.max(dp[i], dp[j] + 1);
					System.out.println(Arrays.toString(dp));
				}
			}
		}

		return Arrays.stream(dp).max().getAsInt();
	}
}
