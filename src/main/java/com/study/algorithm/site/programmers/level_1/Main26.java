package com.study.algorithm.site.programmers.level_1;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;

public class Main26 {

	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 1};
		int[] solution = solution(arr);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	private static int[] solution(int[] arr) {
		if (arr.length == 1) {
			int[] answer = {-1};
			return answer;
		}
		int[] answer = new int[arr.length - 1];

		int min = MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min = min(min, arr[i]);
		}

		int idx = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == min) continue;

			answer[idx++] = arr[i];
		}
		return answer;
	}
}
