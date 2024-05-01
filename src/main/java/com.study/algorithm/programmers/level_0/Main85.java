package com.study.algorithm.programmers.level_0;

import static java.lang.String.valueOf;

public class Main85 {
	public static void main(String[] args) {
		int solution = solution(7);
		System.out.println("solution = " + solution);
	}

	static int solution(int n) {
		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer++;
			while (answer % 3 == 0 || valueOf(answer).contains("3")) {
				answer++;
			}
		}
		return answer;
	}
}