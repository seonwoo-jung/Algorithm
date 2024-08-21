package com.study.algorithm.site.programmers.level_2;

public class Main15 {

	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));
	}

	private static int solution(int n, int a, int b) {
		int round = 0;
		while (a != b) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
			round++;
		}
		return round;
	}
}
