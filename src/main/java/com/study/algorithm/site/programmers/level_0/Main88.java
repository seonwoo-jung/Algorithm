package com.study.algorithm.site.programmers.level_0;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * 겹치는 선분의 길이
 */
public class Main88 {
	public static void main(String[] args) {
		int[][] arr = {{0, 2}, {-3, -1}, {-2, 1}};
		int solution = solution2(arr);
		System.out.println("solution result = " + solution);
	}

	static int solution(int[][] dots) {
		// 1. arr 배열 및 변수 초기화
		int answer = 0;
		int[] arr = new int[200];

		// 2. lines 정보를 arr 배열에 적용
		for (int i = 0; i < dots.length; i++) {
			for (int j = dots[i][0] + 100; j < dots[i][1] + 100; j++) {
				arr[j]++;
			}
		}

		// 3. arr 배열에서 겹친 부분 세기
		for (int i = 0; i < 200; i++) {
			if (arr[i] > 1) {
				answer++;
			}
		}

		return answer;
	}

	static int solution2(int[][] lines) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] line : lines) {
			int from = min(line[0], line[1]);
			int to = max(line[0], line[1]);
			for (int i = from; i < to; i++) {
				map.merge(i, 1, Integer::sum);
			}
		}

		return (int) map.values().stream().filter(i -> i > 1).count();
	}
}