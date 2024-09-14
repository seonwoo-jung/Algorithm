package com.study.algorithm.site.programmers.level_0;

public class Main54 {

	public static void main(String[] args) {
		int solution = solution(7);
		System.out.println("solution = " + solution);
	}

	private static int solution(int n) {
		int answer = 0;

		for (int i = 1; i <= 10; i++) {
			if (n >= factorial(i)) {
				answer = i;
			} else {
				break;
			}
		}
		return answer;
	}

	private static int factorial(int number) {
		if (number > 1) return number * factorial(number - 1);
		return number;
	}
}