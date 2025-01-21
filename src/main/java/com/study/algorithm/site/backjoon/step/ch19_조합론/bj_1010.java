package com.study.algorithm.site.backjoon.step.ch19_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1010 {

	private static int[][] dy = new int[35][35];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			System.out.println(DFS(m, n));
		}
	}

	private static int DFS(int n, int r) {
		if (dy[n][r] > 0) return dy[n][r];

		if (n == r || r == 0) {
			return 1;
		}

		return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
	}
}