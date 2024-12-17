package com.study.algorithm.inflearn.middle.ch06_dfs;

import java.util.Scanner;

/**
 * 중복순열 구하기
 */
public class 중복순열구하기 {

	private static int[] pm;
	private static int n, m;

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
			// n번 가닥이 뻗는다
			for (int i = 1; i <= n; i++) {
				pm[L] = i;
				DFS(L + 1);
			}
		}
	}
}
