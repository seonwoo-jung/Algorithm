package com.study.algorithm.book.doit_middle.ch10_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2775_부녀회장이될테야 {

	private static int[][] dy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dy = new int[15][15];

		while (T --> 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(DFS(k, n));
		}
	}

	private static int DFS(int k, int n) {
		if (n == 1) {
			return 1;
		}
		if (k == 0) {
			return n;
		}

		return dy[k][n] = DFS(k, n - 1) + DFS(k - 1, n);
	}
}