package com.study.algorithm.inflearn.middle.ch05_greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 이진수 정렬
 */
public class Main1 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{5, 6, 7, 8, 9})));
		System.out.println(Arrays.toString(solution(new int[]{5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
	}

	private static int[] solution(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int x : nums) {
			map.put(x, Integer.bitCount(x));
		}

		System.out.println("map = " + map);

		int[] array = map.entrySet()
			.stream()
			.sorted((o1, o2) -> {
				int compare = Integer.compare(o1.getValue(), o2.getValue());
				if (compare == 0) {
					return Integer.compare(o1.getKey(), o2.getKey());
				}
				return compare;
			})
			.mapToInt(Entry::getKey)
			.toArray();
		return array;
	}
}
