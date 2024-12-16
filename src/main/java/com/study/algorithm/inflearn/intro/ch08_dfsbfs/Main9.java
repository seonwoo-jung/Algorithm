package com.study.algorithm.inflearn.intro.ch08_dfsbfs;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 조합구하기
 */
public class Main9 {

	private static int[] combi;
	private static int n, m;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt();
		m = kb.nextInt();
		combi = new int[m];
		DFS(0, 1);
	}

	private static void DFS(int L, int s) {
		if (L == m) {
			for (int x : combi) System.out.printf(x + " ");
			System.out.println();
		} else {
			for (int i = s; i <= n; i++) {
				combi[L] = i;
				DFS(L + 1, i + 1);
			}
		}
	}
}
