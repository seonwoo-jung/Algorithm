package com.study.algorithm.book.codingtest_learn.ch09_트리;

public class Main26_예상대진표 {

	public static void main(String[] args) {
		System.out.println(solution(8,4,7));
	}

	private static int solution(int n, int a, int b) {
		int answer;

		for (answer = 0; a != b; answer++) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
		}

		return answer;
	}
}