package com.study.algorithm.book.codingtest_learn.ch15;

import java.util.Arrays;

public class Main68 {

	public static void main(String[] args) {
		int solution1 = solution(new int[]{1, 4, 2, 3, 1, 5, 7, 3});
//		int solution2 = solution(new int[]{3, 2, 1});
		System.out.println("solution = " + solution1);
//		System.out.println("solution = " + solution2);
	}

	private static int solution(int[] nums) {
		int n = nums.length;

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("nums[%d] = %d nums[%d] = %d\n", i, nums[i], j, nums[j]);
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		return Arrays.stream(dp).max().getAsInt();
	}
}
