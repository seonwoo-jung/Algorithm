package com.study.algorithm.site.programmers.level_1;

import java.util.Arrays;

public class Main75 {

	private static int[] fibo;

	public static void main(String[] args) {
		int solution = solution(3);
		int solution1 = solution(5);
		System.out.println("solution = " + solution);
		System.out.println("solution1 = " + solution1);
	}

	private static int solution(int n) {
		fibo = new int[n + 1];
		DFS(n);
		System.out.println(Arrays.toString(fibo));
		return fibo[n];
	}

	private static int DFS(int n) {
		if (fibo[n] > 0) {
			return fibo[n];
		}
		if (n == 1) {
			return fibo[n] = 1;
		} else if (n == 2) {
			return fibo[n] = 1;
		} else {
			return fibo[n] = (DFS(n - 2) + DFS(n - 1)) % 1234567;
		}
	}
}
