package com.study.algorithm.site.programmers.level_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main16 {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
	}

	private static int solution(int k, int[] tangerine) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i : tangerine) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int[] array = map.entrySet().stream().sorted((o1, o2) ->
			Integer.compare(o2.getValue(), o1.getValue())
		).mapToInt(Entry::getValue).toArray();

		for (int i : array) {
			k = k - i;
			answer++;
			if (k <= 0) return answer;
		}

		return answer;
	}
}
