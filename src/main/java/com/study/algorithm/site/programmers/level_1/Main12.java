package com.study.algorithm.site.programmers.level_1;


public class Main12 {

	public static void main(String[] args) {
		long solution = solution(3);
		System.out.println("solution = " + solution);
	}

	static long solution(int n) {
		if (Math.pow((int) Math.sqrt(n), 2) == n) {
			return (long) Math.pow(Math.sqrt(n) + 1, 2);
		}

		return -1;
	}
}
