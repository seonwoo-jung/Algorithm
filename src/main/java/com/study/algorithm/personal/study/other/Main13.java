package com.study.algorithm.personal.study.other;

import java.util.Arrays;

public class Main13 {

	private static int[] fibo;

	public static void main(String[] args) {
		int n = 9555;
		fibo = new int[n + 1];
		int dfs = DFS(n);
		System.out.println(Arrays.toString(fibo));
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
			return fibo[n] = DFS(n - 2) + DFS(n - 1);
		}
	}
}