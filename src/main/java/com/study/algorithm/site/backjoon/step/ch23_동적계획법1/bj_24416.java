package com.study.algorithm.site.backjoon.step.ch23_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_24416 {

	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int a = DFS(N);
		int b = N - 2;
		System.out.printf("%d %d", a, b);
	}

	private static int DFS(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return DFS(n - 1) + DFS(n - 2);
		}
	}
}