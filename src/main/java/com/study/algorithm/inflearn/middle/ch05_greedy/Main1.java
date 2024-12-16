package com.study.algorithm.inflearn.middle.ch05_greedy;

import java.util.Arrays;

/**
 * 침몰하는 타이타닉
 */
public class Main1 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{90, 50, 70, 100, 60}, 140));
		System.out.println(solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
		System.out.println(solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
	}

	private static int solution(int[] nums, int m) {
		int answer = 0;
		int lt = 0, rt = nums.length - 1;
		Arrays.sort(nums);

		// 마지막에는 한개만 남을 수 있기 때문에 <=를 사용하는 것
		while (lt <= rt) {
			if (nums[lt] + nums[rt] <= m) {
				lt++;
			}
			rt--;
			answer++;
		}

		return answer;
	}
}
