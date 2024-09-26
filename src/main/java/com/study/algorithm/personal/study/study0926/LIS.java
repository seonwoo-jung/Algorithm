package com.study.algorithm.personal.study.study0926;

import java.util.Arrays;

/**
 * LIS
 */
public class LIS {

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
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		System.out.println(Arrays.toString(dp));

		return Arrays.stream(dp).max().getAsInt();
	}
}
