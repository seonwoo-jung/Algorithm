package com.study.algorithm.programmers.level_1;

import java.util.HashSet;

/**
 * 폰켓몬
 */
public class Main18 {

	public static void main(String[] args) {
		int[] nums = {3, 1, 2, 3};
		int solution = solution(nums);
		System.out.println("solution = " + solution);
	}

	static int solution(int[] nums) {
		int max = nums.length / 2;

		HashSet<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		if (set.size() > max) {
			return max;
		} else {
			return set.size();
		}
	}
}
