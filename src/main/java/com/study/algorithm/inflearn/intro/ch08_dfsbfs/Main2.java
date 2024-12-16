package com.study.algorithm.inflearn.intro.ch08_dfsbfs;

import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.in;

public class Main2 {

	private static int answer = MIN_VALUE, c, n;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		c = kb.nextInt();
		n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		DFS(0, 0, arr);
		System.out.println(answer);
	}

	private static void DFS(int L, int sum, int[] arr) {
		if (sum > c) return;
		if (L == n) answer = Math.max(answer, sum);
		else {
			DFS(L + 1, sum + arr[L], arr);
			DFS(L + 1, sum, arr);
		}
	}
}
