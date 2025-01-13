package com.study.algorithm.inflearn.middle.ch05_greedy;

import java.util.Arrays;

/**
 * 이동 횟수
 */
public class Main2_이동횟수 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 5, 3, 4, 2, 3}));
		System.out.println(solution(new int[]{2, 3, 4, 5}));
		System.out.println(solution(new int[]{3, 3, 3, 3, 3}));
	}

	private static int solution(int[] nums) {
		int answer = 0;
		int lt = 0, rt = nums.length - 1;
		Arrays.sort(nums);

		// 마지막에는 한개만 남을 수 있기 때문에 <=를 사용하는 것
		while (lt <= rt) {
			if (nums[lt] + nums[rt] <= 5) {
				lt++;
			}
			rt--;
			answer++;
		}

		return answer;
	}
}
