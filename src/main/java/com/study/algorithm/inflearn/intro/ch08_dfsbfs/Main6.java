package com.study.algorithm.inflearn.intro.ch08_dfsbfs;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 순열구하기
 */
public class Main6 {

	private static int[] pm, ch, arr;
	private static int n, m;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt();
		m = kb.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
		ch = new int[n];
		pm = new int[m];
		DFS(0);
	}

	private static void DFS(int L) {
		if (L == m) {
			for (int x : pm) System.out.print(x + " ");
			System.out.println();
		} else {
			for (int i = 0; i < n; i++) {
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
