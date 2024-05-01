package com.study.algorithm.programmers.level_1;

import static java.util.Arrays.sort;

public class Main34 {

	public static void main(String[] args) {
		int[] d = {1, 3, 2, 5, 4};
		int budget = 9;
		int solution = solution(d, budget);
		System.out.println("solution = " + solution);
	}

	static int solution(int[] d, int budget) {
		sort(d);
		int answer = 0;
		for (int i = 0; i < d.length; i++) {
			if (budget - d[i] >= 0) {
				budget -= d[i];
				answer++;
			} else {
				return answer;
			}
		}
		return answer;
	}
}