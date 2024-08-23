package com.study.algorithm.book.codingtest_learn.ch16;

import java.util.Arrays;

public class Main79 {

	public static void main(String[] args) {
		int solution = solution(new int[]{1, 3, 2, 5, 4}, 9);
		System.out.println("solution = " + solution);
		int solution1 = solution(new int[]{2, 2, 3, 3}, 10);
		System.out.println("solution1 = " + solution1);
	}

	private static int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);

		for (int i : d) {
			if (budget - i < 0) {
				return answer;
			}
			budget -= i;
			answer++;
		}
		return answer;
	}
}
