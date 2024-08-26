package com.study.algorithm.site.programmers.level_2;

import java.util.HashMap;
import java.util.Map;

public class Main18 {

	public static void main(String[] args) {
		System.out.println(solution(
			new String[]{"banana", "apple", "rice", "pork", "pot"},
			new int[]{3, 2, 2, 2, 1},
			new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
				"pork", "rice", "pot", "banana", "apple", "banana"})
		);
	}

	private static int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
		}

		for (int i = 0; i < discount.length - 9; i++) {

			Map<String, Integer> dis = new HashMap<>();

			for (int j = i; j < i + 10; j++) {
				dis.put(discount[j], dis.getOrDefault(discount[j], 0) + 1);
			}
			if (dis.equals(map)) {
				answer++;
			}
		}

		return answer;
	}
}
