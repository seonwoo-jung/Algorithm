package com.study.algorithm.personal.greedy;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 친구인가 (서로소)
 */
public class UnionAndFind {

	static int[] unf;

	private static int Find(int v) {
		if (v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}

	private static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if (fa != fb) unf[fa] = fb;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int m = kb.nextInt();

		unf = new int[n + 1];

		for (int i = 1; i <= n; i++) unf[i] = i;

		for (int i = 1; i <= m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			Union(a, b);
		}

		int a = kb.nextInt();
		int b = kb.nextInt();
		int fa = Find(a);
		int fb = Find(b);
		if (fa == fb) System.out.println("YES");
		else System.out.println("NO");
	}
}
