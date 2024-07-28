package com.study.algorithm.personal.dfs;

import java.util.Scanner;

import static java.lang.System.in;

// 조합수
// todo: 이해필요
public class DFS13 {

	static int[] b, p, ch;
	static int n, f;
	static boolean flag = false;
	static int[][] dy = new int[35][35]; // 메모이제이션

	static void DFS(int L, int sum) {

		if (flag) return;

		// 순열 완성
		if (L == n) {
			if (sum == f) {
				for (int x : p) System.out.printf("%d ", x);
				flag = true;
			}
		} else {
			for (int i = 1; i <= n; i++) {
				if (ch[i] == 0) {
					ch[i] = 1; // i값 자체가 데이터 (인덱스 아님)
					p[L] = i;
					DFS(L + 1, sum + (p[L] * b[L]));
					ch[i] = 0;
				}
			}
		}
	}

	static int combi(int n, int r) {
		if (dy[n][r] > 0) return dy[n][r];
		if (n == r || r == 0) return 1;
		else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt(); // 가장 윗줄에 있는 숫자의 개수
		f = kb.nextInt(); // 가장 밑에 줄에 있는 수
		b = new int[n];
		p = new int[n];
		ch = new int[n + 1];

		for (int i = 0; i < n; i++) {
			b[i] = combi(n - 1, i);
		}
		DFS(0, 0);
	}
}