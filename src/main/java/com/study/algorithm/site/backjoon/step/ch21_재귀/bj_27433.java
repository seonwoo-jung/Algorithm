package com.study.algorithm.site.backjoon.step.ch21_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_27433 {

	private static long[] dy = new long[21];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dy[0] = dy[1] = 1;
		System.out.println(DFS(n));
	}

	private static long DFS(int n) {
		if (dy[n] > 0) {
			return dy[n];
		}
		return dy[n] = n * DFS(n - 1);
	}
}