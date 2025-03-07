package com.study.algorithm.book.codingtest_learn.ch05.recommend;

import java.util.Arrays;

/**
 * 주어진 값으로 특정한 값을 내는 규칙을 찾으라는 뜻
 */
public class Main3_n제곱배열자르기 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 2, 5)));
		System.out.println(Arrays.toString(solution(4,7,14)));
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
