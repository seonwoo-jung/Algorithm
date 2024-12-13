package com.study.algorithm.inflearn.middle.ch04_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 이진수 정렬
 */
public class Main2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
		System.out.println(Arrays.toString(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}

	private static int[] solution(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length / 2;
		int count = 0;

		for (int x : nums) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		for (int num : nums) {
			if (count == n)
				break;

			if (map.getOrDefault(num * 2, 0) == 0) {
				continue;
			}

			map.put(num, map.get(num) - 1);
			list.add(num);
			count++;
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
