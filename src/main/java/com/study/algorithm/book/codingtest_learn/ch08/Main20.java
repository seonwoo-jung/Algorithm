package com.study.algorithm.book.codingtest_learn.ch08;

import java.util.HashMap;
import java.util.Map;

public class Main20 {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
	}

	private static int solution(String[] want, int[] number, String[] discount) {
		Map<String, Integer> wantMap = new HashMap<>();

		for (int i = 0; i < want.length; i++) {
			wantMap.put(want[i], number[i]);
		}
		int answer = 0;

		for (int i = 0; i < discount.length - 9; i++) {
			Map<String, Integer> discount10d = new HashMap<>();

			for (int j = i; j < i + 10; j++) {
				if (wantMap.containsKey(discount[j])) {
					discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
				}
			}
			if (wantMap.equals(discount10d)) {
				answer++;
			}
		}

		return answer;
	}
}
