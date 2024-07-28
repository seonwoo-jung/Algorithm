package com.study.algorithm.inflearn.intro.ch08;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * (다시보기)
 * 수열 추측하기
 */
public class Main8 {

	static int[] b, p, ch;
	static int n, f;
	static boolean flag = false;
	static int[][] dy = new int[35][35]; // 콤비네이션 메모이제이션

	static int combi(int n, int r) {
		if (dy[n][r] > 0) return dy[n][r];
		if (n == r || r == 0) return 1;
		else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}

	static void DFS(int L, int sum) {
		if (flag) return;
		if (L == n) {
			if (sum == f) {
				for (int x : p) System.out.print(x + " ");
				flag = true;
			}
		} else {
			for (int i = 1; i <= n; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;
					p[L] = i;
					DFS(L + 1, sum + (p[L] * b[L]));
					ch[i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt(); // 4
		f = kb.nextInt(); // 16
		b = new int[n];
		p = new int[n];
		ch = new int[n + 1]; // 체크배열
		for (int i = 0; i < n; i++) {
			b[i] = combi(n - 1, i);
		}
		DFS(0, 0);
	}
}
