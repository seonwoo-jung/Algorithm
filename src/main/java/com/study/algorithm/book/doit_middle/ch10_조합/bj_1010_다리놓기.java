package com.study.algorithm.book.doit_middle.ch10_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1010_다리놓기 {

	private static int[][] dy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dy = new int[30][30];

		while (T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			System.out.println(DFS(M, N));
		}
	}

	private static int DFS(int n, int r) {
		if (r == 0 || n == r) {
			return 1;
		}

		return dy[n][r] = DFS(n - 1, r) + DFS(n - 1, r - 1);
	}
}