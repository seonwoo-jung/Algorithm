package com.study.algorithm.inflearn.intro.ch07_recursive;

/**
 * 부분집합 구하기(DFS)
 */
public class Main6_부분집합구하기 {
	private static int N;
	private static int[] ch;

	public static void main(String[] args) {
		N = 3;
		ch = new int[N + 1];
		DFS(1);
	}

	private static void DFS(int L) {
		if (L == N + 1) {
			String tmp = "";
			for (int i = 1; i <= N; i++) {
				if (ch[i] == 1) tmp += (i + " ");
			}
			if (!tmp.isEmpty()) {
				System.out.println(tmp);
			}
		} else {
			ch[L] = 1;
			DFS(L + 1); // 왼쪽
			ch[L] = 0;
			DFS(L + 1); // 오른쪽
		}
	}
}
