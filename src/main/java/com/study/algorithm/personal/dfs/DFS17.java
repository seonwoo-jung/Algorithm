package com.study.algorithm.personal.dfs;

public class DFS17 {

	private static int[] arr, ch, pm;
	private static int N, M;

	public static void main(String[] args) {
		N = 3;
		M = 2;
		ch = new int[N];
		pm = new int[M];
		arr = new int[]{3, 6, 9};
		DFS(0);
	}

	private static void DFS(int L) {
		if (L == M) {
			for (int x : pm) {
				System.out.printf("%d ", x);
			}
			System.out.println();
		} else {
			for (int i = 0; i < N; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;
					pm[L] = arr[i];
					DFS(L + 1);
					ch[i] = 0;
				}
			}
		}
	}
}