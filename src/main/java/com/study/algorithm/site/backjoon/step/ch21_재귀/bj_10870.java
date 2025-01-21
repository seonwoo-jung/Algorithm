package com.study.algorithm.site.backjoon.step.ch21_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_10870 {

	private static int[] fibo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		fibo = new int[n + 1];
		System.out.println(DFS(n));
	}

	private static int DFS(int n) {
		if (n == 0) return 0;
		if (fibo[n] > 0) {
			return fibo[n];
		}
		if (n == 1) {
			return fibo[n] = 1;
		} else if (n == 2) {
			return fibo[n] = 1;
		} else {
			return fibo[n] = DFS(n - 1) + DFS(n - 2);
		}
	}
}