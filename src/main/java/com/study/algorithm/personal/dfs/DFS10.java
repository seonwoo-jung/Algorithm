package com.study.algorithm.personal.dfs;

import java.util.Scanner;

import static java.lang.System.in;

// 중복순열
public class DFS10 {

	static int[] pm;
	static int n, m;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		pm = new int[m];
		DFS(0);
	}

	private static void DFS(int L) {
		if (L == m) {
			for (int x : pm) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			for (int i = 1; i <= n; i++) {
				pm[L] = i;
				DFS(L + 1);
			}
		}
	}
}
