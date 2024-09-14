package com.study.algorithm.site.programmers.level_0;

public class Main66 {

	public static void main(String[] args) {
		int n = 10;
		int solution = solution(n);
		System.out.println("solution = " + solution);
	}

	private static int solution(int n) {
		int sum = 0;
		for (int i = 2; i <= n; i += 2) {
			sum += i;
		}
		return sum;
	}
}