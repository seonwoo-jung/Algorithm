package com.study.algorithm.site.programmers.level_0;

public class Main67 {

	public static void main(String[] args) {
		int n = 10;
		int k = 3;
		int solution = solution(n, k);
		System.out.println("solution = " + solution);
	}

	private static int solution(int n, int k) {
		int num = n / 10;
		k = num != 0 ? k - num : k;
		return n * 12000 + k * 2000;
	}
}