package com.study.algorithm.inflearn.middle.ch04_sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 이진수 정렬
 */
public class Main1_이진수정렬 {

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

		return map.entrySet()
			.stream()
			.sorted((a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : a.getValue() - b.getValue())
//			.sorted(Comparator.comparing(Entry<Integer, Integer>::getValue).thenComparing(Entry::getKey))
			.mapToInt(Entry::getKey)
			.toArray();
	}
}
