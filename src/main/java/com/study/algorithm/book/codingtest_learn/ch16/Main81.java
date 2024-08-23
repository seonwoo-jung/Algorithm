package com.study.algorithm.book.codingtest_learn.ch16;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main81 {

	public static void main(String[] args) {
		int solution = solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
		int solution1 = solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
		int solution2 = solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3});

		System.out.println("solution = " + solution);
		System.out.println("solution1 = " + solution1);
		System.out.println("solution2 = " + solution2);
	}

	private static int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i : tangerine) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int[] answer = map.entrySet().stream().sorted((o1, o2) ->
			Integer.compare(o2.getValue(), o1.getValue())
		).mapToInt(Entry::getValue).toArray();

		int cnt = 0;

		if (k - answer[0] <= 0) {
			return 1;
		}

		for (int i : answer) {
			if (k - i >= 0) {
				k -= i;
				cnt++;
			} else {
				return cnt;
			}
		}

		return cnt;
	}
}
