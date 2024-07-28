package com.study.algorithm.site.programmers.level_0;

public class Main84 {
	public static void main(String[] args) {
		int solution = solution(10);
		System.out.println("solution = " + solution);
	}

	static int solution(int n) {
		int answer = 0, pizza = 1, piece = 6;
		for (int i = 1; i <= 100; i++) {
			if ((pizza * piece) % n == 0) {
				answer = pizza;
				return answer;
			} else {
				pizza++;
			}
		}
		return answer;
	}
}