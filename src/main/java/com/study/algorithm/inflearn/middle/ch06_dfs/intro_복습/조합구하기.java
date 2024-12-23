package com.study.algorithm.inflearn.middle.ch06_dfs.intro_복습;

import java.util.Scanner;

/**
 * 조합구하기 (조합의 경우는 그냥 외워버리기)
 */
public class 조합구하기 {

	private static int[] combi;
	private static int n, m;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		combi = new int[m];
		DFS(0, 1); // level, start번호
	}

	private static void DFS(int L, int s) {
		// level이 m이 되면, 조합이 완성
		if (L == m) {
			for (int x : combi) {
				System.out.printf(x + " ");
			}
			System.out.println();
		} else {
			// 넘어온 숫자부터 n까지 반복한다.
			for (int i = s; i <= n; i++) {
				combi[L] = i;
				DFS(L + 1, i + 1);
			}
		}
	}
}
