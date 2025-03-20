package com.study.algorithm.book.doit_middle.ch10_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11050_이항계수구하기 {

	private static int[][] dy = new int[35][35];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		dy = new int[n + 1][r + 1];

		System.out.println(DFS(n, r));
	}

	private static int DFS(int n, int r) {
		if (r == 0) {
			return 1;
		}
		if (n == r) {
			return 1;
		}

		if (dy[n][r] > 0) {
			return dy[n][r];
		}

		return dy[n][r] = DFS(n - 1, r) + DFS(n - 1, r - 1);
	}
}
