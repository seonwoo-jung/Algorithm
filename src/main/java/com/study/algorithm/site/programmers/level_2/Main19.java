package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

public class Main19 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 2, 5)));
	}

	private static int[] solution(int n, long left, long right) {
		int[] answer = new int[(int) (right - left) + 1];

		int idx = 0;
		for (long i = left; i <= right; i++) {
			long row = i / n + 1;
			long col = i % n + 1;
			answer[idx++] = (int) Math.max(row, col);
		}

		return answer;
	}
}
