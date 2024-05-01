package com.study.algorithm.inflearn.ch08;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 조합구하기
 */
public class Main9 {

	static int[] combi;
	static int n, m;

	static void DFS(int L, int s) {
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

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt();
		m = kb.nextInt();
		combi = new int[m];
		DFS(0, 1);
	}
}
