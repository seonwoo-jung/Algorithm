package com.study.algorithm.site.backjoon.step.ch19_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_10872 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(DFS(n));
	}

	private static int DFS(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * DFS(n - 1);
		}
	}
}