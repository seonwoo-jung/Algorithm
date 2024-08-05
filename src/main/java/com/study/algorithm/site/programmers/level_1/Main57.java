package com.study.algorithm.site.programmers.level_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 프로그래머스 - 실패율
 */
public class Main57 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
		System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));
	}

	public static int[] solution(int N, int[] stages) {
		int[] score = new int[N + 2];

		for (int i = 0; i < stages.length; i++) {
			score[stages[i]]++;
		}

		Map<Integer, Double> map = new HashMap();
		double existPlayer = stages.length;

		for (int i = 1; i <= N; i++) {
			if (score[i] == 0) {
				map.put(i, 0.);
			} else {
				map.put(i, score[i] / existPlayer);
				existPlayer -= score[i];
			}
		}

		return map.entrySet().stream().sorted((o1, o2) ->
			Double.compare(o2.getValue(), o1.getValue())
		).mapToInt(Entry::getKey).toArray();
	}
}
