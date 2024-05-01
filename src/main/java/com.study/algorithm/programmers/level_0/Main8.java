package com.study.algorithm.programmers.level_0;

public class Main8 {

	public static void main(String[] args) {

		System.out.println(solution2(7, 15));
	}

	static int solution(int n, int t) {

		int answer = 0;
		int result = 0;

		for (int i = 0; i < t; i++) {
			n *= 2;
		}

		return n;
	}

	static int solution2(int n, int t) {
		int answer = 0;

		answer = n << t;

		return answer;
	}
}
