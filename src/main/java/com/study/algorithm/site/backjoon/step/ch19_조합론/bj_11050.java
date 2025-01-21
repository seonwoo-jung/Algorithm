package com.study.algorithm.site.backjoon.step.ch19_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_11050 {

	private static int[][] dy = new int[35][35];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);

		System.out.println(DFS(n, k));
	}

	private static int DFS(int n, int r) {
		if (dy[n][r] > 0) return dy[n][r];

		if (n == r || r == 0) {
			return 1;
		}

		return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
	}
}