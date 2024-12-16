package com.study.algorithm.inflearn.middle.ch04_sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 수열 찾기
 */
public class Main2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
		System.out.println(Arrays.toString(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}

	private static int[] solution(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] answer = new int [nums.length / 2];
		Arrays.sort(nums);
		int idx = 0;

		for (int x : nums) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		for (int x : nums) {
			if (map.get(x) == 0) continue;

			answer[idx++] = x;
			map.put(x, map.get(x) - 1);
			map.put(x * 2, map.get(x * 2) - 1);
		}

		return answer;
	}
}
