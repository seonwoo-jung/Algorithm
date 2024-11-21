package com.study.algorithm.inflearn.intro.ch07;

/**
 * 부분집합 구하기(DFS)
 */
public class Main6 {
	private static int N;
	private static int[] ch;

	public static void main(String[] args) {
		N = 3;
		ch = new int[N + 1];
		DFS2(1);
	}

	private static void DFS2(int L) {
		if (L == N + 1) {
			for (int i = 1; i <= N; i++) {
				if (ch[i] == 1) {
					System.out.printf("%d ", i);
				}
			}
			System.out.println();
		} else {
			ch[L] = 1;
			DFS2(L + 1);
			ch[L] = 0;
			DFS2(L + 1);
		}
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
